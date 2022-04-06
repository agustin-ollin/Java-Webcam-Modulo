package data;

import java.io.File;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u0010\u001a\u00020\u0004J\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0012"},
        d2 = {"Ldata/AudioUtils;", "", "()V", "reproducirEntrada", "", "reproducirError", "reproducirMp3CorrectSinRiesgoEntrada", "reproducirMp3CorrectoSospechosoEntrada", "reproducirMp3CorrectoVulnerableEntrada", "reproducirMp3ErrorRiesgo", "reproducirMp3RIESGO", "audioUrl", "", "reproducirMp3SINRIESGO", "reproducirMp3Sospechoso", "reproducirMp3Vulnerable", "reproducirNohaEchoSuEncuesta", "reproducirSalida", "modulo-covitvo-webcam.main"}
)
public final class AudioUtils {

    public final void reproducirMp3CorrectSinRiesgoEntrada() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/correct.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(800L);
            this.reproducirMp3SINRIESGO("sonidos/sinriesgo.mp3");
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirMp3SINRIESGO(@NotNull String audioUrl) {
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        new JFXPanel();
        Media hit = new Media((new File(audioUrl)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }

    public final void reproducirMp3ErrorRiesgo() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/erroraudio.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
            this.reproducirMp3RIESGO("sonidos/enriesgo.mp3");
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirMp3RIESGO(@NotNull String audioUrl) {
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        new JFXPanel();
        Media hit = new Media((new File(audioUrl)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }

    public final void reproducirMp3CorrectoSospechosoEntrada() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/correct.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
            this.reproducirMp3Sospechoso("sonidos/sospechoso.mp3");
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirMp3Sospechoso(@NotNull String audioUrl) {
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        new JFXPanel();
        Media hit = new Media((new File(audioUrl)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }

    public final void reproducirMp3CorrectoVulnerableEntrada() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/correct.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
            this.reproducirMp3Vulnerable("sonidos/vulnerable.mp3");
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirMp3Vulnerable(@NotNull String audioUrl) {
        Intrinsics.checkNotNullParameter(audioUrl, "audioUrl");
        new JFXPanel();
        Media hit = new Media((new File(audioUrl)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        }

    }

    public final void reproducirNohaEchoSuEncuesta() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/noencuesta.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(6000L);
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirEntrada() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/entrada.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirSalida() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/salida.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }

    public final void reproducirError() {
        new JFXPanel();
        Media hit = new Media((new File("sonidos/errorda.mp3")).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

        try {
            Thread.sleep(2500L);
        } catch (InterruptedException var5) {
            var5.printStackTrace();
        }

    }
}
