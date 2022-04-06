package data;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002Be\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\"\u001a\u00020\u0004HÆ\u0003J\t\u0010#\u001a\u00020\u0004HÆ\u0003J\t\u0010$\u001a\u00020\u0004HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0004HÆ\u0003J\t\u0010'\u001a\u00020\u0004HÆ\u0003J\t\u0010(\u001a\u00020\u0004HÆ\u0003J\t\u0010)\u001a\u00020\u0004HÆ\u0003J\t\u0010*\u001a\u00020\u0004HÆ\u0003J\t\u0010+\u001a\u00020\u0004HÆ\u0003J\t\u0010,\u001a\u00020\u0004HÆ\u0003J\t\u0010-\u001a\u00020\u0004HÆ\u0003J\u0081\u0001\u0010.\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u00042\b\b\u0002\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0013\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u000203HÖ\u0001J\t\u00104\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\u000b\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0013¨\u00065"},
   d2 = {"Ldata/EntradaSalidaHistorico;", "", "()V", "id", "", "uid", "nombreCompleto", "correo", "identificador", "tipoDeUsuario", "especialidad", "estatusCovid", "tipoRegistro", "fechaRegistro", "horaRegistro", "createdAt", "Lcom/google/cloud/Timestamp;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/cloud/Timestamp;)V", "getCorreo", "()Ljava/lang/String;", "getCreatedAt", "()Lcom/google/cloud/Timestamp;", "getEspecialidad", "getEstatusCovid", "setEstatusCovid", "(Ljava/lang/String;)V", "getFechaRegistro", "getHoraRegistro", "getId", "getIdentificador", "getNombreCompleto", "getTipoDeUsuario", "getTipoRegistro", "getUid", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "modulo-covitvo-webcam.main"}
)
public final class EntradaSalidaHistorico {
   @DocumentId
   @NotNull
   private final String id;
   @NotNull
   private final String uid;
   @NotNull
   private final String nombreCompleto;
   @NotNull
   private final String correo;
   @NotNull
   private final String identificador;
   @NotNull
   private final String tipoDeUsuario;
   @NotNull
   private final String especialidad;
   @NotNull
   private String estatusCovid;
   @NotNull
   private final String tipoRegistro;
   @NotNull
   private final String fechaRegistro;
   @NotNull
   private final String horaRegistro;
   @NotNull
   private final Timestamp createdAt;

   @NotNull
   public final String getId() {
      return this.id;
   }

   @NotNull
   public final String getUid() {
      return this.uid;
   }

   @NotNull
   public final String getNombreCompleto() {
      return this.nombreCompleto;
   }

   @NotNull
   public final String getCorreo() {
      return this.correo;
   }

   @NotNull
   public final String getIdentificador() {
      return this.identificador;
   }

   @NotNull
   public final String getTipoDeUsuario() {
      return this.tipoDeUsuario;
   }

   @NotNull
   public final String getEspecialidad() {
      return this.especialidad;
   }

   @NotNull
   public final String getEstatusCovid() {
      return this.estatusCovid;
   }

   public final void setEstatusCovid(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.estatusCovid = var1;
   }

   @NotNull
   public final String getTipoRegistro() {
      return this.tipoRegistro;
   }

   @NotNull
   public final String getFechaRegistro() {
      return this.fechaRegistro;
   }

   @NotNull
   public final String getHoraRegistro() {
      return this.horaRegistro;
   }

   @NotNull
   public final Timestamp getCreatedAt() {
      return this.createdAt;
   }

   public EntradaSalidaHistorico(@NotNull String id, @NotNull String uid, @NotNull String nombreCompleto, @NotNull String correo, @NotNull String identificador, @NotNull String tipoDeUsuario, @NotNull String especialidad, @NotNull String estatusCovid, @NotNull String tipoRegistro, @NotNull String fechaRegistro, @NotNull String horaRegistro, @NotNull Timestamp createdAt) {
      super();
      Intrinsics.checkNotNullParameter(id, "id");
      Intrinsics.checkNotNullParameter(uid, "uid");
      Intrinsics.checkNotNullParameter(nombreCompleto, "nombreCompleto");
      Intrinsics.checkNotNullParameter(correo, "correo");
      Intrinsics.checkNotNullParameter(identificador, "identificador");
      Intrinsics.checkNotNullParameter(tipoDeUsuario, "tipoDeUsuario");
      Intrinsics.checkNotNullParameter(especialidad, "especialidad");
      Intrinsics.checkNotNullParameter(estatusCovid, "estatusCovid");
      Intrinsics.checkNotNullParameter(tipoRegistro, "tipoRegistro");
      Intrinsics.checkNotNullParameter(fechaRegistro, "fechaRegistro");
      Intrinsics.checkNotNullParameter(horaRegistro, "horaRegistro");
      Intrinsics.checkNotNullParameter(createdAt, "createdAt");

      this.id = id;
      this.uid = uid;
      this.nombreCompleto = nombreCompleto;
      this.correo = correo;
      this.identificador = identificador;
      this.tipoDeUsuario = tipoDeUsuario;
      this.especialidad = especialidad;
      this.estatusCovid = estatusCovid;
      this.tipoRegistro = tipoRegistro;
      this.fechaRegistro = fechaRegistro;
      this.horaRegistro = horaRegistro;
      this.createdAt = createdAt;
   }

   public EntradaSalidaHistorico() {
      this("", "", "", "", "", "", "", "", "", "", "", Timestamp.now());
      /*Timestamp var10012 = Timestamp.now();
      Intrinsics.checkNotNullExpressionValue(var10012, "Timestamp.now()");
      this("", "", "", "", "", "", "", "", "", "", "", var10012);*/
   }

   @NotNull
   public final String component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.uid;
   }

   @NotNull
   public final String component3() {
      return this.nombreCompleto;
   }

   @NotNull
   public final String component4() {
      return this.correo;
   }

   @NotNull
   public final String component5() {
      return this.identificador;
   }

   @NotNull
   public final String component6() {
      return this.tipoDeUsuario;
   }

   @NotNull
   public final String component7() {
      return this.especialidad;
   }

   @NotNull
   public final String component8() {
      return this.estatusCovid;
   }

   @NotNull
   public final String component9() {
      return this.tipoRegistro;
   }

   @NotNull
   public final String component10() {
      return this.fechaRegistro;
   }

   @NotNull
   public final String component11() {
      return this.horaRegistro;
   }

   @NotNull
   public final Timestamp component12() {
      return this.createdAt;
   }

   @NotNull
   public final EntradaSalidaHistorico copy(@NotNull String id, @NotNull String uid, @NotNull String nombreCompleto, @NotNull String correo, @NotNull String identificador, @NotNull String tipoDeUsuario, @NotNull String especialidad, @NotNull String estatusCovid, @NotNull String tipoRegistro, @NotNull String fechaRegistro, @NotNull String horaRegistro, @NotNull Timestamp createdAt) {
      Intrinsics.checkNotNullParameter(id, "id");
      Intrinsics.checkNotNullParameter(uid, "uid");
      Intrinsics.checkNotNullParameter(nombreCompleto, "nombreCompleto");
      Intrinsics.checkNotNullParameter(correo, "correo");
      Intrinsics.checkNotNullParameter(identificador, "identificador");
      Intrinsics.checkNotNullParameter(tipoDeUsuario, "tipoDeUsuario");
      Intrinsics.checkNotNullParameter(especialidad, "especialidad");
      Intrinsics.checkNotNullParameter(estatusCovid, "estatusCovid");
      Intrinsics.checkNotNullParameter(tipoRegistro, "tipoRegistro");
      Intrinsics.checkNotNullParameter(fechaRegistro, "fechaRegistro");
      Intrinsics.checkNotNullParameter(horaRegistro, "horaRegistro");
      Intrinsics.checkNotNullParameter(createdAt, "createdAt");
      return new EntradaSalidaHistorico(id, uid, nombreCompleto, correo, identificador, tipoDeUsuario, especialidad, estatusCovid, tipoRegistro, fechaRegistro, horaRegistro, createdAt);
   }

   // $FF: synthetic method
   public static EntradaSalidaHistorico copy$default(EntradaSalidaHistorico var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, String var11, Timestamp var12, int var13, Object var14) {
      if ((var13 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var13 & 2) != 0) {
         var2 = var0.uid;
      }

      if ((var13 & 4) != 0) {
         var3 = var0.nombreCompleto;
      }

      if ((var13 & 8) != 0) {
         var4 = var0.correo;
      }

      if ((var13 & 16) != 0) {
         var5 = var0.identificador;
      }

      if ((var13 & 32) != 0) {
         var6 = var0.tipoDeUsuario;
      }

      if ((var13 & 64) != 0) {
         var7 = var0.especialidad;
      }

      if ((var13 & 128) != 0) {
         var8 = var0.estatusCovid;
      }

      if ((var13 & 256) != 0) {
         var9 = var0.tipoRegistro;
      }

      if ((var13 & 512) != 0) {
         var10 = var0.fechaRegistro;
      }

      if ((var13 & 1024) != 0) {
         var11 = var0.horaRegistro;
      }

      if ((var13 & 2048) != 0) {
         var12 = var0.createdAt;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12);
   }

   @NotNull
   public String toString() {
      return "EntradaSalidaHistorico(id=" + this.id + ", uid=" + this.uid + ", nombreCompleto=" + this.nombreCompleto + ", correo=" + this.correo + ", identificador=" + this.identificador + ", tipoDeUsuario=" + this.tipoDeUsuario + ", especialidad=" + this.especialidad + ", estatusCovid=" + this.estatusCovid + ", tipoRegistro=" + this.tipoRegistro + ", fechaRegistro=" + this.fechaRegistro + ", horaRegistro=" + this.horaRegistro + ", createdAt=" + this.createdAt + ")";
   }

   public int hashCode() {
      String var10000 = this.id;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.uid;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.nombreCompleto;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.correo;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.identificador;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.tipoDeUsuario;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.especialidad;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.estatusCovid;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.tipoRegistro;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.fechaRegistro;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.horaRegistro;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      Timestamp var2 = this.createdAt;
      return var1 + (var2 != null ? var2.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (!(var1 instanceof EntradaSalidaHistorico)) {
            return false;
         }

         EntradaSalidaHistorico var2 = (EntradaSalidaHistorico)var1;
         if (!Intrinsics.areEqual(this.id, var2.id) || !Intrinsics.areEqual(this.uid, var2.uid) || !Intrinsics.areEqual(this.nombreCompleto, var2.nombreCompleto) || !Intrinsics.areEqual(this.correo, var2.correo) || !Intrinsics.areEqual(this.identificador, var2.identificador) || !Intrinsics.areEqual(this.tipoDeUsuario, var2.tipoDeUsuario) || !Intrinsics.areEqual(this.especialidad, var2.especialidad) || !Intrinsics.areEqual(this.estatusCovid, var2.estatusCovid) || !Intrinsics.areEqual(this.tipoRegistro, var2.tipoRegistro) || !Intrinsics.areEqual(this.fechaRegistro, var2.fechaRegistro) || !Intrinsics.areEqual(this.horaRegistro, var2.horaRegistro) || !Intrinsics.areEqual(this.createdAt, var2.createdAt)) {
            return false;
         }
      }

      return true;
   }
}