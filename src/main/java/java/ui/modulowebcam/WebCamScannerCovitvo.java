package java.ui.modulowebcam;

import com.google.cloud.Timestamp;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.QRCodeReader;

import data.AudioUtils;
import data.DateConverterUtils;
import data.Encuesta;
import data.FirebaseUtils;
import mx.com.divaga.covitvo.data.EncuestaUsuario;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;
import java.qrscanner.BufferedImageLuminanceSource;
import java.ui.Utils.Navigation;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebCamScannerCovitvo extends javax.swing.JFrame {
    private static JFrame frame;
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The video
     */
    private Video<MBFImage> video;
    /**
     * The video display which will play the video
     */
    private VideoDisplay<MBFImage> videoDisplay;
    /**
     * The image component into which the video is being painted (reused)
     */
    private DisplayUtilities.ImageComponent ic;
    /**
     * The thread which is running the video playback
     */
    private Thread videoThread;

    private BufferedImage bimg;
    Reader reader;

    String lastImage; // This will have the cover image
    private URL url;
    long timeLastMatched;

    static FirebaseUtils f;

    /*public WebCamScannerCovitvo() {
        initComponents();
    }*/

    /**
     * Set the Size of the Screen in JFrame
     */
    private static void screenSize() {
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screen.height;
        int width = screen.width;
        try {
            frame = Navigation.initForm(new WebCamScannerCovitvo().panel, width, height, "REGISTRO ENTRADA/SALIDA");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Change the icon of the frame
     */
    private static void changeIcon() {
        Image icon = Toolkit.getDefaultToolkit().getImage("images/itvo.png");
        frame.setIconImage(icon);
    }

    /**
     * Set the video source to be the webcam
     *
     * @throws IOException
     */
    public void startCam() throws IOException {
        video = new VideoCapture(640, 480);
        videoDisplay = new VideoDisplay<MBFImage>(video, ic);
        videoDisplay.addVideoListener(this);
        videoThread = new Thread(videoDisplay);
        videoThread.start();
    }

    public WebCamScannerCovitvo() throws IOException {
        initComponents();
        frame = this;
        ActionListener updateClockAction = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(new Date().getTime());

                int mYear = calendar.get(Calendar.YEAR);
                int mMonth = calendar.get(Calendar.MONTH);
                int mDay = calendar.get(Calendar.DAY_OF_MONTH);

                int hora = calendar.get(Calendar.HOUR_OF_DAY);
                int minutos = calendar.get(Calendar.MINUTE);
                int segundos = calendar.get(Calendar.SECOND);

                reloj.setText("HORA Y FECHA: " + mDay + "-" + (mMonth + 1) + "-" + mYear + " A LAS " + hora + ":" + minutos + ":" + segundos);
            }
        };
        Timer t = new Timer(1000, updateClockAction);
        t.start();

    }

    public void getDataFromFirebase(String Uid) {

        setFieldsDataFromFirebase(f.getEncuestaUsuarioByUid(Uid));

    }

    public void setFieldsDataFromFirebase(EncuestaUsuario encuestaUsuario) {

        ImageIcon imageIcon = null;

        String lastDate = new DateConverterUtils().getDateString(encuestaUsuario.getLastUpdated());
        String nowDate = new DateConverterUtils().getDateString(Timestamp.now());

        if (!lastDate.contains(nowDate)) {
            new AudioUtils().reproducirNohaEchoSuEncuesta();
        } else if (lastDate.contains(nowDate)) {

            esperando.setText("CODIGO ESCANEADO CON EXITO");
            riesgo.setText("RESULTADO DE LA ENCUESTA: " + encuestaUsuario.getRiesgoText());
            ultimaEncuesta.setText("ULTIMA ENCUESTA: " + encuestaUsuario.toString());
            correo.setText(encuestaUsuario.getEmail().toUpperCase(Locale.ROOT));
            nombreCompleto.setText(encuestaUsuario.getNombre().toUpperCase(Locale.ROOT));
            telefono.setText(encuestaUsuario.getTelefono());
            tipoUsuario.setText(encuestaUsuario.getUniversityRol().toUpperCase(Locale.ROOT));
            especialidad.setText(encuestaUsuario.getUniversitySpecialty().toUpperCase(Locale.ROOT));

            Encuesta encuesta = f.getLastFromList(encuestaUsuario.getResultados());

            respuesta1.setText(encuesta.getPreguntasRespuestas().get(0).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(0).getRespuesta());
            respuesta2.setText(encuesta.getPreguntasRespuestas().get(1).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(1).getRespuesta());
            respuesta3.setText(encuesta.getPreguntasRespuestas().get(2).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(2).getRespuesta());
            respuesta4.setText(encuesta.getPreguntasRespuestas().get(3).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(3).getRespuesta());
            respuesta5.setText(encuesta.getPreguntasRespuestas().get(4).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(4).getRespuesta());
            respuesta6.setText(encuesta.getPreguntasRespuestas().get(5).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(5).getRespuesta());
            respuesta7.setText(encuesta.getPreguntasRespuestas().get(6).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(6).getRespuesta());
            respuesta8.setText(encuesta.getPreguntasRespuestas().get(7).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(7).getRespuesta());
            respuesta9.setText(encuesta.getPreguntasRespuestas().get(8).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(8).getRespuesta());
            respuesta10.setText(encuesta.getPreguntasRespuestas().get(9).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(9).getRespuesta());
            respuesta11.setText(encuesta.getPreguntasRespuestas().get(10).getPregunta() + " -> " + encuesta.getPreguntasRespuestas().get(10).getRespuesta());

            if (encuestaUsuario.getRiesgoText().equals("SIN RIESGO")) {
                imageIcon = new ImageIcon(new ImageIcon("images/sinriesgo.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));

                if (imageIcon != null) {
                    imagenEscaneoLabel.setIcon(imageIcon);
                }
                new AudioUtils().reproducirMp3CorrectSinRiesgoEntrada();
            }

            if (encuestaUsuario.getRiesgoText().equals("RIESGO")) {
                imageIcon = new ImageIcon(new ImageIcon("images/riesgo.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));

                if (imageIcon != null) {
                    imagenEscaneoLabel.setIcon(imageIcon);
                }
                new AudioUtils().reproducirMp3ErrorRiesgo();
            }

            if (encuestaUsuario.getRiesgoText().equals("SOSPECHOSO") && !encuesta.getPreguntasRespuestas().get(6).getRespuesta().equals("SI")) {
                imageIcon = new ImageIcon(new ImageIcon("images/sospechoso.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));

                if (imageIcon != null) {
                    imagenEscaneoLabel.setIcon(imageIcon);
                }
                new AudioUtils().reproducirMp3CorrectoSospechosoEntrada();

            }

            if (encuestaUsuario.getRiesgoText().equals("SOSPECHOSO") && encuesta.getPreguntasRespuestas().get(6).getRespuesta().equals("SI")) {
                riesgo.setText("VULNERABLE");
                imageIcon = new ImageIcon(new ImageIcon("images/sinriesgo.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));

                if (imageIcon != null) {
                    imagenEscaneoLabel.setIcon(imageIcon);
                }
                new AudioUtils().reproducirMp3CorrectoVulnerableEntrada();
            }

            new FirebaseUtils().registrarEntradaSalida(encuestaUsuario, new DateConverterUtils().getDateStringPLUS1(Timestamp.now()), new DateConverterUtils().getDateTimeString(Timestamp.now()), new DateConverterUtils().getDateTimeStringForHistorico(Timestamp.now()));

            try {
                Thread.sleep(1000); //don't exit too early
                clean();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    private void clean() {
        imagenEscaneoLabel.setIcon(null);
        esperando.setText("ESPERANDO CODIGO QR");
        riesgo.setText("RESULTADO DE LA ENCUESTA: ");
        ultimaEncuesta.setText("ULTIMA ENCUESTA: ");
        correo.setText("CORREO: ");
        nombreCompleto.setText("NOMBRE COMPLETO: ");
        telefono.setText("TELÉFONO: ");
        tipoUsuario.setText("TIPO DE USUARIO: ");
        especialidad.setText("ESPECIALIDAD: ");
        respuesta1.setText("¿PREGUNTA 1?");
        respuesta2.setText("¿PREGUNTA 2?");
        respuesta3.setText("¿PREGUNTA 3?");
        respuesta4.setText("¿PREGUNTA 4?");
        respuesta5.setText("¿PREGUNTA 5?");
        respuesta6.setText("¿PREGUNTA 6?");
        respuesta7.setText("¿PREGUNTA 7?");
        respuesta8.setText("¿PREGUNTA 8?");
        respuesta9.setText("¿PREGUNTA 9?");
        respuesta10.setText("¿PREGUNTA 10?");
        respuesta11.setText("¿PREGUNTA 11?");

    }

    private void initCamera() throws IOException {
        ic = new DisplayUtilities.ImageComponent(false);
        ic.setShowXYPosition(false);
        ic.setAllowPanning(false);
        ic.setAllowZoom(false);
        ic.setPreferredSize(new Dimension(640, 400));
        reader = new QRCodeReader();
        lastImage = "";
        startCam();
        JPanel jPanel = new JPanel();
        jPanel.add(ic);
        camera = jPanel;
    }

    private void createUIComponents() throws IOException {

        initCamera();

        ImageIcon imageIcon = new ImageIcon(new ImageIcon("images/itvo.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT));
        logo = new JLabel(imageIcon);

        imagenEscaneoLabel = new JLabel(imageIcon);

    }

    //@Override
    public void afterUpdate(VideoDisplay<MBFImage> display) {

        if (System.currentTimeMillis() - timeLastMatched > 100) {
        }
    }

    //@Override
    public void beforeUpdate(MBFImage frame) {
        bimg = ImageUtilities.createBufferedImageForDisplay(frame, bimg);
        LuminanceSource source = new BufferedImageLuminanceSource(bimg);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            Result result = reader.decode(bitmap);
            if (result.getText() != null) {
                //don't exit too early
                System.out.println("ENTRADO");
                getDataFromFirebase(result.getText());
                System.out.print("\n<RESULT>".concat(result.getText()).concat("</RESULT> \n"));
            }

        } catch (Exception ignored) {

        }
    }

    Clip clip;

    private void doPlay(final String url) {
        try {
            stopPlay();
            AudioInputStream inputStream = AudioSystem
                    .getAudioInputStream(getClass().getResourceAsStream(url));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            stopPlay();
            System.err.println(e.getMessage());
        }
    }

    private void stopPlay() {
        if (clip != null) {
            clip.stop();
            clip.close();
            clip = null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panel = new javax.swing.JPanel();
        camera = new javax.swing.JPanel();
        info = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        riesgo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelDatos = new javax.swing.JPanel();
        ultimaEncuesta = new javax.swing.JLabel();
        correo = new javax.swing.JLabel();
        nombreCompleto = new javax.swing.JLabel();
        telefono = new javax.swing.JLabel();
        tipoUsuario = new javax.swing.JLabel();
        especialidad = new javax.swing.JLabel();
        panelRespuestas = new javax.swing.JPanel();
        respuesta1 = new javax.swing.JLabel();
        respuesta2 = new javax.swing.JLabel();
        respuesta3 = new javax.swing.JLabel();
        respuesta4 = new javax.swing.JLabel();
        respuesta5 = new javax.swing.JLabel();
        respuesta6 = new javax.swing.JLabel();
        respuesta7 = new javax.swing.JLabel();
        respuesta8 = new javax.swing.JLabel();
        respuesta9 = new javax.swing.JLabel();
        respuesta10 = new javax.swing.JLabel();
        respuesta11 = new javax.swing.JLabel();
        panelHorizontal = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        covitvo = new javax.swing.JLabel();
        reloj = new javax.swing.JLabel();
        esperando = new javax.swing.JLabel();
        imagenEscaneoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("frame"); // NOI18N

        camera.setLayout(new java.awt.GridLayout(1, 1));

        riesgo.setText("RESULTADO DE ENCUESTA:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(riesgo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(648, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(riesgo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridBagLayout());

        panelDatos.setLayout(new java.awt.GridLayout(6, 1));

        ultimaEncuesta.setText("ÚLTIMA ENCUESTA:");
        panelDatos.add(ultimaEncuesta);

        correo.setText("CORREO:");
        panelDatos.add(correo);

        nombreCompleto.setText("NOMBRE COMPLETO:");
        panelDatos.add(nombreCompleto);

        telefono.setText("TELÉFONO:");
        panelDatos.add(telefono);

        tipoUsuario.setText("TIPO DE USUARIO:");
        panelDatos.add(tipoUsuario);

        especialidad.setText("ESPECIALIDAD:");
        panelDatos.add(especialidad);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 50);
        jPanel2.add(panelDatos, gridBagConstraints);

        panelRespuestas.setLayout(new java.awt.GridLayout(6, 2));

        respuesta1.setText("¿PREGUNTA 1?");
        panelRespuestas.add(respuesta1);

        respuesta2.setText("¿PREGUNTA 2?");
        panelRespuestas.add(respuesta2);

        respuesta3.setText("¿PREGUNTA 3?");
        panelRespuestas.add(respuesta3);

        respuesta4.setText("¿PREGUNTA 4?");
        panelRespuestas.add(respuesta4);

        respuesta5.setText("¿PREGUNTA 5?");
        panelRespuestas.add(respuesta5);

        respuesta6.setText("¿PREGUNTA 6?");
        panelRespuestas.add(respuesta6);

        respuesta7.setText("¿PREGUNTA 7?");
        panelRespuestas.add(respuesta7);

        respuesta8.setText("¿PREGUNTA 8?");
        panelRespuestas.add(respuesta8);

        respuesta9.setText("¿PREGUNTA 9?");
        panelRespuestas.add(respuesta9);

        respuesta10.setText("¿PREGUNTA 10?");
        panelRespuestas.add(respuesta10);

        respuesta11.setText("¿PREGUNTA 11?");
        panelRespuestas.add(respuesta11);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 10, 10);
        jPanel2.add(panelRespuestas, gridBagConstraints);

        javax.swing.GroupLayout infoLayout = new javax.swing.GroupLayout(info);
        info.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelHorizontal.setLayout(new java.awt.GridLayout(6, 1));

        logo.setText("jLabel1");
        panelHorizontal.add(logo);

        titulo.setText("MÓDULO DE REGISTRO ENTRADA/SALIDA");
        panelHorizontal.add(titulo);

        covitvo.setText("COVITVO");
        panelHorizontal.add(covitvo);
        panelHorizontal.add(reloj);

        esperando.setText("ESPERANDO CÓDIGO QR ...");
        panelHorizontal.add(esperando);
        panelHorizontal.add(imagenEscaneoLabel);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addComponent(camera, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelHorizontal, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
            .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(camera, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelHorizontal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WebCamScannerCovitvo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WebCamScannerCovitvo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WebCamScannerCovitvo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WebCamScannerCovitvo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
            screenSize();
            changeIcon();

            //frame = Navigation.initForm(new WebCamScannerCovitvo().panel, 1400, 1000, "REGISTRO ENTRADA/SALIDA");
            f = new FirebaseUtils();
            f.initFirebase();
        } catch (Exception ex) {
            System.err.println(ex);
        }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel camera;
    private javax.swing.JLabel correo;
    private javax.swing.JLabel covitvo;
    private javax.swing.JLabel especialidad;
    private javax.swing.JLabel esperando;
    private javax.swing.JLabel imagenEscaneoLabel;
    private javax.swing.JPanel info;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel nombreCompleto;
    private javax.swing.JPanel panel;
    private javax.swing.JPanel panelDatos;
    private javax.swing.JPanel panelHorizontal;
    private javax.swing.JPanel panelRespuestas;
    private javax.swing.JLabel reloj;
    private javax.swing.JLabel respuesta1;
    private javax.swing.JLabel respuesta10;
    private javax.swing.JLabel respuesta11;
    private javax.swing.JLabel respuesta2;
    private javax.swing.JLabel respuesta3;
    private javax.swing.JLabel respuesta4;
    private javax.swing.JLabel respuesta5;
    private javax.swing.JLabel respuesta6;
    private javax.swing.JLabel respuesta7;
    private javax.swing.JLabel respuesta8;
    private javax.swing.JLabel respuesta9;
    private javax.swing.JLabel riesgo;
    private javax.swing.JLabel telefono;
    private javax.swing.JLabel tipoUsuario;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel ultimaEncuesta;
    // End of variables declaration//GEN-END:variables
}
