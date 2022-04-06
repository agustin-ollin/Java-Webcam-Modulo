
package java.qrscanner;


import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import org.openimaj.image.DisplayUtilities;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.MBFImage;
import org.openimaj.video.Video;
import org.openimaj.video.VideoDisplay;
import org.openimaj.video.VideoDisplayListener;
import org.openimaj.video.capture.VideoCapture;
import java.ui.modulowebcam.WebCamScannerCovitvo;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class QRScanner extends JPanel implements
        VideoDisplayListener<MBFImage> {
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
    com.google.zxing.Reader reader;

    String lastImage; // This will have the cover image
    private URL url;
    long timeLastMatched;


    public QRScanner() throws IOException {
        setBackground(Color.BLACK);
        ic = new DisplayUtilities.ImageComponent(false);
        ic.setShowXYPosition(false);
        ic.setAllowPanning(false);
        ic.setAllowZoom(false);
        ic.setPreferredSize(new Dimension(640, 400));
        reader = new com.google.zxing.qrcode.QRCodeReader();
        lastImage = "";
        this.add(ic);
        startCam();
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


    /**
     * {@inheritDoc}
     *
     * @see org.openimaj.video.VideoDisplayListener#afterUpdate(org.openimaj.video.VideoDisplay)
     */
    @Override
    public void afterUpdate(VideoDisplay<MBFImage> display) {
        if (System.currentTimeMillis() - timeLastMatched > 100) {
        }
    }


    /**
     * {@inheritDoc}
     */

    @Override
    public void beforeUpdate(MBFImage frame) {
        bimg = ImageUtilities.createBufferedImageForDisplay(frame, bimg);
        LuminanceSource source = new BufferedImageLuminanceSource(bimg);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        try {
            Result result = reader.decode(bitmap);
            if (result.getText() != null) {
                Toolkit.getDefaultToolkit().beep();
                JOptionPane.showMessageDialog(null, result.getText());
                System.out.print("\n<RESULT>".concat(result.getText()).concat("</RESULT> \n"));
            }

        } catch (Exception ignored) {

        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            System.out.print(args);
            final JPanel southPanel = new JPanel();
            FlowLayout layout = (FlowLayout) southPanel.getLayout();
            layout.setVgap(0);

            QRScanner qrScanner = new QRScanner();
            JFrame base = new JFrame("QR code scanner");
            base.setResizable(false);
            base.add(qrScanner);
            base.setSize(640, 480);
            base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            base.setLocationByPlatform(true);
            base.setVisible(true);
            base.setBackground(Color.BLACK);

        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
