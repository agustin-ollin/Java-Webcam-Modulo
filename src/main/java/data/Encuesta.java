package data;

import com.google.cloud.Timestamp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0004HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"},
   d2 = {"Ldata/Encuesta;", "", "()V", "numPreguntas", "", "preguntasRespuestas", "", "Ldata/PreguntaRespuesta;", "resultadoRiesgoAcumulado", "createdAt", "Lcom/google/cloud/Timestamp;", "(ILjava/util/List;ILcom/google/cloud/Timestamp;)V", "getCreatedAt", "()Lcom/google/cloud/Timestamp;", "getNumPreguntas", "()I", "setNumPreguntas", "(I)V", "getPreguntasRespuestas", "()Ljava/util/List;", "setPreguntasRespuestas", "(Ljava/util/List;)V", "getResultadoRiesgoAcumulado", "setResultadoRiesgoAcumulado", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "modulo-covitvo-webcam.main"}
)
public final class Encuesta {
   private int numPreguntas;
   @NotNull
   private List preguntasRespuestas;
   private int resultadoRiesgoAcumulado;
   @NotNull
   private final Timestamp createdAt;

   public final int getNumPreguntas() {
      return this.numPreguntas;
   }

   public final void setNumPreguntas(int var1) {
      this.numPreguntas = var1;
   }

   @NotNull
   public final List getPreguntasRespuestas() {
      return this.preguntasRespuestas;
   }

   public final void setPreguntasRespuestas(@NotNull List var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.preguntasRespuestas = var1;
   }

   public final int getResultadoRiesgoAcumulado() {
      return this.resultadoRiesgoAcumulado;
   }

   public final void setResultadoRiesgoAcumulado(int var1) {
      this.resultadoRiesgoAcumulado = var1;
   }

   @NotNull
   public final Timestamp getCreatedAt() {
      return this.createdAt;
   }

   public Encuesta(int numPreguntas, @NotNull List preguntasRespuestas, int resultadoRiesgoAcumulado, @NotNull Timestamp createdAt) {
      super();
      Intrinsics.checkNotNullParameter(preguntasRespuestas, "preguntasRespuestas");
      Intrinsics.checkNotNullParameter(createdAt, "createdAt");
      this.numPreguntas = numPreguntas;
      this.preguntasRespuestas = preguntasRespuestas;
      this.resultadoRiesgoAcumulado = resultadoRiesgoAcumulado;
      this.createdAt = createdAt;
   }

   /**
    * Se cambió la estructura del método
    */
   public Encuesta() {
      this(0, CollectionsKt.listOf(new PreguntaRespuesta()), 0, Timestamp.now());
//      List var10002 = CollectionsKt.listOf(new PreguntaRespuesta());
//      Timestamp var10004 = Timestamp.now();
//      Intrinsics.checkNotNullExpressionValue(var10004, "Timestamp.now()");
//      this(0, var10002, 0, var10004);
   }

   public final int component1() {
      return this.numPreguntas;
   }

   @NotNull
   public final List component2() {
      return this.preguntasRespuestas;
   }

   public final int component3() {
      return this.resultadoRiesgoAcumulado;
   }

   @NotNull
   public final Timestamp component4() {
      return this.createdAt;
   }

   @NotNull
   public final Encuesta copy(int numPreguntas, @NotNull List preguntasRespuestas, int resultadoRiesgoAcumulado, @NotNull Timestamp createdAt) {
      Intrinsics.checkNotNullParameter(preguntasRespuestas, "preguntasRespuestas");
      Intrinsics.checkNotNullParameter(createdAt, "createdAt");
      return new Encuesta(numPreguntas, preguntasRespuestas, resultadoRiesgoAcumulado, createdAt);
   }

   // $FF: synthetic method
   public static Encuesta copy$default(Encuesta var0, int var1, List var2, int var3, Timestamp var4, int var5, Object var6) {
      if ((var5 & 1) != 0) {
         var1 = var0.numPreguntas;
      }

      if ((var5 & 2) != 0) {
         var2 = var0.preguntasRespuestas;
      }

      if ((var5 & 4) != 0) {
         var3 = var0.resultadoRiesgoAcumulado;
      }

      if ((var5 & 8) != 0) {
         var4 = var0.createdAt;
      }

      return var0.copy(var1, var2, var3, var4);
   }

   @NotNull
   public String toString() {
      return "Encuesta(numPreguntas=" + this.numPreguntas + ", preguntasRespuestas=" + this.preguntasRespuestas + ", resultadoRiesgoAcumulado=" + this.resultadoRiesgoAcumulado + ", createdAt=" + this.createdAt + ")";
   }

   public int hashCode() {
      int var10000 = Integer.hashCode(this.numPreguntas) * 31;
      List var10001 = this.preguntasRespuestas;
      var10000 = ((var10000 + (var10001 != null ? var10001.hashCode() : 0)) * 31 + Integer.hashCode(this.resultadoRiesgoAcumulado)) * 31;
      Timestamp var1 = this.createdAt;
      return var10000 + (var1 != null ? var1.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof Encuesta) {
            Encuesta var2 = (Encuesta)var1;
            if (this.numPreguntas == var2.numPreguntas && Intrinsics.areEqual(this.preguntasRespuestas, var2.preguntasRespuestas) && this.resultadoRiesgoAcumulado == var2.resultadoRiesgoAcumulado && Intrinsics.areEqual(this.createdAt, var2.createdAt)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}