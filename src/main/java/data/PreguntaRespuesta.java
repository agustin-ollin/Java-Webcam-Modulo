package data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0019"},
   d2 = {"Ldata/PreguntaRespuesta;", "", "()V", "pregunta", "", "respuesta", "peligro", "", "(Ljava/lang/String;Ljava/lang/String;I)V", "getPeligro", "()I", "setPeligro", "(I)V", "getPregunta", "()Ljava/lang/String;", "getRespuesta", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "modulo-covitvo-webcam.main"}
)
public final class PreguntaRespuesta {
   @NotNull
   private final String pregunta;
   @NotNull
   private final String respuesta;
   private int peligro;

   @NotNull
   public final String getPregunta() {
      return this.pregunta;
   }

   @NotNull
   public final String getRespuesta() {
      return this.respuesta;
   }

   public final int getPeligro() {
      return this.peligro;
   }

   public final void setPeligro(int var1) {
      this.peligro = var1;
   }

   public PreguntaRespuesta(@NotNull String pregunta, @NotNull String respuesta, int peligro) {
      super();
      Intrinsics.checkNotNullParameter(pregunta, "pregunta");
      Intrinsics.checkNotNullParameter(respuesta, "respuesta");
      
      this.pregunta = pregunta;
      this.respuesta = respuesta;
      this.peligro = peligro;
   }

   public PreguntaRespuesta() {
      this("", "", 0);
   }

   @NotNull
   public final String component1() {
      return this.pregunta;
   }

   @NotNull
   public final String component2() {
      return this.respuesta;
   }

   public final int component3() {
      return this.peligro;
   }

   @NotNull
   public final PreguntaRespuesta copy(@NotNull String pregunta, @NotNull String respuesta, int peligro) {
      Intrinsics.checkNotNullParameter(pregunta, "pregunta");
      Intrinsics.checkNotNullParameter(respuesta, "respuesta");
      return new PreguntaRespuesta(pregunta, respuesta, peligro);
   }

   // $FF: synthetic method
   public static PreguntaRespuesta copy$default(PreguntaRespuesta var0, String var1, String var2, int var3, int var4, Object var5) {
      if ((var4 & 1) != 0) {
         var1 = var0.pregunta;
      }

      if ((var4 & 2) != 0) {
         var2 = var0.respuesta;
      }

      if ((var4 & 4) != 0) {
         var3 = var0.peligro;
      }

      return var0.copy(var1, var2, var3);
   }

   @NotNull
   public String toString() {
      return "PreguntaRespuesta(pregunta=" + this.pregunta + ", respuesta=" + this.respuesta + ", peligro=" + this.peligro + ")";
   }

   public int hashCode() {
      String var10000 = this.pregunta;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.respuesta;
      return (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31 + Integer.hashCode(this.peligro);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof PreguntaRespuesta) {
            PreguntaRespuesta var2 = (PreguntaRespuesta)var1;
            if (Intrinsics.areEqual(this.pregunta, var2.pregunta) && Intrinsics.areEqual(this.respuesta, var2.respuesta) && this.peligro == var2.peligro) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}