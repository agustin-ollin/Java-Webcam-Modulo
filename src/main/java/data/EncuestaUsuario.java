package data;

//package mx.com.divaga.covitvo.data;

import com.google.cloud.Timestamp;
import com.google.cloud.firestore.annotation.DocumentId;
import data.Encuesta;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b0\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0083\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0002\u0010\u0017J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\t\u00106\u001a\u00020\u0004HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0012HÆ\u0003J\t\u00109\u001a\u00020\u0012HÆ\u0003J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J\t\u0010;\u001a\u00020\u0004HÆ\u0003J\t\u0010<\u001a\u00020\u0004HÆ\u0003J\t\u0010=\u001a\u00020\u0004HÆ\u0003J\t\u0010>\u001a\u00020\u0004HÆ\u0003J\t\u0010?\u001a\u00020\u0004HÆ\u0003J\t\u0010@\u001a\u00020\u0004HÆ\u0003J\t\u0010A\u001a\u00020\u0004HÆ\u0003J\t\u0010B\u001a\u00020\u0004HÆ\u0003J¥\u0001\u0010C\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0001J\u0013\u0010D\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010F\u001a\u00020GHÖ\u0001J\b\u0010H\u001a\u00020\u0004H\u0016R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0013\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010)R\u001a\u0010\u000f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001b\"\u0004\b+\u0010,R\u001a\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010,R\u0011\u0010\b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001b¨\u0006I"},
   d2 = {"Lmx/com/divaga/covitvo/data/EncuestaUsuario;", "", "()V", "id", "", "nombre", "status", "email", "telefono", "userUid", "universityId", "universityRol", "universitySpecialty", "riesgo", "", "riesgoText", "permiso", "duracionPermiso", "Lcom/google/cloud/Timestamp;", "lastUpdated", "resultados", "", "Ldata/Encuesta;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLcom/google/cloud/Timestamp;Lcom/google/cloud/Timestamp;Ljava/util/List;)V", "getDuracionPermiso", "()Lcom/google/cloud/Timestamp;", "getEmail", "()Ljava/lang/String;", "getId", "getLastUpdated", "setLastUpdated", "(Lcom/google/cloud/Timestamp;)V", "getNombre", "getPermiso", "()Z", "getResultados", "()Ljava/util/List;", "setResultados", "(Ljava/util/List;)V", "getRiesgo", "setRiesgo", "(Z)V", "getRiesgoText", "setRiesgoText", "(Ljava/lang/String;)V", "getStatus", "setStatus", "getTelefono", "getUniversityId", "getUniversityRol", "getUniversitySpecialty", "getUserUid", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "modulo-covitvo-webcam.main"}
)
public final class EncuestaUsuario {
   @DocumentId
   @NotNull
   private final String id;
   @NotNull
   private final String nombre;
   @NotNull
   private String status;
   @NotNull
   private final String email;
   @NotNull
   private final String telefono;
   @NotNull
   private final String userUid;
   @NotNull
   private final String universityId;
   @NotNull
   private final String universityRol;
   @NotNull
   private final String universitySpecialty;
   private boolean riesgo;
   @NotNull
   private String riesgoText;
   private final boolean permiso;
   @NotNull
   private final Timestamp duracionPermiso;
   @NotNull
   private Timestamp lastUpdated;
   @NotNull
   private List resultados;

   @NotNull
   public String toString() {
      String var10000 = this.lastUpdated.toString();
      Intrinsics.checkNotNullExpressionValue(var10000, "lastUpdated.toString()");
      String var1 = var10000;
      byte var2 = 0;
      byte var3 = 10;
      String var4 = var1.substring(var2, var3);
      Intrinsics.checkNotNullExpressionValue(var4, "this as java.lang.String…ing(startIndex, endIndex)");
      return String.valueOf(var4);
   }

   @NotNull
   public final String getId() {
      return this.id;
   }

   @NotNull
   public final String getNombre() {
      return this.nombre;
   }

   @NotNull
   public final String getStatus() {
      return this.status;
   }

   public final void setStatus(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.status = var1;
   }

   @NotNull
   public final String getEmail() {
      return this.email;
   }

   @NotNull
   public final String getTelefono() {
      return this.telefono;
   }

   @NotNull
   public final String getUserUid() {
      return this.userUid;
   }

   @NotNull
   public final String getUniversityId() {
      return this.universityId;
   }

   @NotNull
   public final String getUniversityRol() {
      return this.universityRol;
   }

   @NotNull
   public final String getUniversitySpecialty() {
      return this.universitySpecialty;
   }

   public final boolean getRiesgo() {
      return this.riesgo;
   }

   public final void setRiesgo(boolean var1) {
      this.riesgo = var1;
   }

   @NotNull
   public final String getRiesgoText() {
      return this.riesgoText;
   }

   public final void setRiesgoText(@NotNull String var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.riesgoText = var1;
   }

   public final boolean getPermiso() {
      return this.permiso;
   }

   @NotNull
   public final Timestamp getDuracionPermiso() {
      return this.duracionPermiso;
   }

   @NotNull
   public final Timestamp getLastUpdated() {
      return this.lastUpdated;
   }

   public final void setLastUpdated(@NotNull Timestamp var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.lastUpdated = var1;
   }

   @NotNull
   public final List getResultados() {
      return this.resultados;
   }

   public final void setResultados(@NotNull List var1) {
      Intrinsics.checkNotNullParameter(var1, "<set-?>");
      this.resultados = var1;
   }

   public EncuestaUsuario(@NotNull String id, @NotNull String nombre, @NotNull String status, @NotNull String email, @NotNull String telefono, @NotNull String userUid, @NotNull String universityId, @NotNull String universityRol, @NotNull String universitySpecialty, boolean riesgo, @NotNull String riesgoText, boolean permiso, @NotNull Timestamp duracionPermiso, @NotNull Timestamp lastUpdated, @NotNull List resultados) {
      super();
      Intrinsics.checkNotNullParameter(id, "id");
      Intrinsics.checkNotNullParameter(nombre, "nombre");
      Intrinsics.checkNotNullParameter(status, "status");
      Intrinsics.checkNotNullParameter(email, "email");
      Intrinsics.checkNotNullParameter(telefono, "telefono");
      Intrinsics.checkNotNullParameter(userUid, "userUid");
      Intrinsics.checkNotNullParameter(universityId, "universityId");
      Intrinsics.checkNotNullParameter(universityRol, "universityRol");
      Intrinsics.checkNotNullParameter(universitySpecialty, "universitySpecialty");
      Intrinsics.checkNotNullParameter(riesgoText, "riesgoText");
      Intrinsics.checkNotNullParameter(duracionPermiso, "duracionPermiso");
      Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
      Intrinsics.checkNotNullParameter(resultados, "resultados");
      //super();
      this.id = id;
      this.nombre = nombre;
      this.status = status;
      this.email = email;
      this.telefono = telefono;
      this.userUid = userUid;
      this.universityId = universityId;
      this.universityRol = universityRol;
      this.universitySpecialty = universitySpecialty;
      this.riesgo = riesgo;
      this.riesgoText = riesgoText;
      this.permiso = permiso;
      this.duracionPermiso = duracionPermiso;
      this.lastUpdated = lastUpdated;
      this.resultados = resultados;
   }

   /**
    * Se cambió la estructura del proyecto
    */
   public EncuestaUsuario() {
       this("", "", "", "", "", "", "", "", "", false, "", false, Timestamp.now(), Timestamp.now(), CollectionsKt.listOf(new Encuesta()));
//      Timestamp var10013 = Timestamp.now();
//      Intrinsics.checkNotNullExpressionValue(var10013, "Timestamp.now()");
//      Timestamp var10014 = Timestamp.now();
//      Intrinsics.checkNotNullExpressionValue(var10014, "Timestamp.now()");
//      this("", "", "", "", "", "", "", "", "", false, "", false, var10013, var10014, CollectionsKt.listOf(new Encuesta()));
   }

   @NotNull
   public final String component1() {
      return this.id;
   }

   @NotNull
   public final String component2() {
      return this.nombre;
   }

   @NotNull
   public final String component3() {
      return this.status;
   }

   @NotNull
   public final String component4() {
      return this.email;
   }

   @NotNull
   public final String component5() {
      return this.telefono;
   }

   @NotNull
   public final String component6() {
      return this.userUid;
   }

   @NotNull
   public final String component7() {
      return this.universityId;
   }

   @NotNull
   public final String component8() {
      return this.universityRol;
   }

   @NotNull
   public final String component9() {
      return this.universitySpecialty;
   }

   public final boolean component10() {
      return this.riesgo;
   }

   @NotNull
   public final String component11() {
      return this.riesgoText;
   }

   public final boolean component12() {
      return this.permiso;
   }

   @NotNull
   public final Timestamp component13() {
      return this.duracionPermiso;
   }

   @NotNull
   public final Timestamp component14() {
      return this.lastUpdated;
   }

   @NotNull
   public final List component15() {
      return this.resultados;
   }

   @NotNull
   public final EncuestaUsuario copy(@NotNull String id, @NotNull String nombre, @NotNull String status, @NotNull String email, @NotNull String telefono, @NotNull String userUid, @NotNull String universityId, @NotNull String universityRol, @NotNull String universitySpecialty, boolean riesgo, @NotNull String riesgoText, boolean permiso, @NotNull Timestamp duracionPermiso, @NotNull Timestamp lastUpdated, @NotNull List resultados) {
      Intrinsics.checkNotNullParameter(id, "id");
      Intrinsics.checkNotNullParameter(nombre, "nombre");
      Intrinsics.checkNotNullParameter(status, "status");
      Intrinsics.checkNotNullParameter(email, "email");
      Intrinsics.checkNotNullParameter(telefono, "telefono");
      Intrinsics.checkNotNullParameter(userUid, "userUid");
      Intrinsics.checkNotNullParameter(universityId, "universityId");
      Intrinsics.checkNotNullParameter(universityRol, "universityRol");
      Intrinsics.checkNotNullParameter(universitySpecialty, "universitySpecialty");
      Intrinsics.checkNotNullParameter(riesgoText, "riesgoText");
      Intrinsics.checkNotNullParameter(duracionPermiso, "duracionPermiso");
      Intrinsics.checkNotNullParameter(lastUpdated, "lastUpdated");
      Intrinsics.checkNotNullParameter(resultados, "resultados");
      return new EncuestaUsuario(id, nombre, status, email, telefono, userUid, universityId, universityRol, universitySpecialty, riesgo, riesgoText, permiso, duracionPermiso, lastUpdated, resultados);
   }

   // $FF: synthetic method
   public static EncuestaUsuario copy$default(EncuestaUsuario var0, String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, boolean var10, String var11, boolean var12, Timestamp var13, Timestamp var14, List var15, int var16, Object var17) {
      if ((var16 & 1) != 0) {
         var1 = var0.id;
      }

      if ((var16 & 2) != 0) {
         var2 = var0.nombre;
      }

      if ((var16 & 4) != 0) {
         var3 = var0.status;
      }

      if ((var16 & 8) != 0) {
         var4 = var0.email;
      }

      if ((var16 & 16) != 0) {
         var5 = var0.telefono;
      }

      if ((var16 & 32) != 0) {
         var6 = var0.userUid;
      }

      if ((var16 & 64) != 0) {
         var7 = var0.universityId;
      }

      if ((var16 & 128) != 0) {
         var8 = var0.universityRol;
      }

      if ((var16 & 256) != 0) {
         var9 = var0.universitySpecialty;
      }

      if ((var16 & 512) != 0) {
         var10 = var0.riesgo;
      }

      if ((var16 & 1024) != 0) {
         var11 = var0.riesgoText;
      }

      if ((var16 & 2048) != 0) {
         var12 = var0.permiso;
      }

      if ((var16 & 4096) != 0) {
         var13 = var0.duracionPermiso;
      }

      if ((var16 & 8192) != 0) {
         var14 = var0.lastUpdated;
      }

      if ((var16 & 16384) != 0) {
         var15 = var0.resultados;
      }

      return var0.copy(var1, var2, var3, var4, var5, var6, var7, var8, var9, var10, var11, var12, var13, var14, var15);
   }

   /**
    * Casting de las variables booleanas a bytes
    * @return 
    */
   public int hashCode() {
      String var10000 = this.id;
      int var1 = (var10000 != null ? var10000.hashCode() : 0) * 31;
      String var10001 = this.nombre;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.status;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.email;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.telefono;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.userUid;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.universityId;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.universityRol;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var10001 = this.universitySpecialty;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      byte var2 = (byte)((this.riesgo)? 1 : 0);
      //byte var2 = this.riesgo;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      var10001 = this.riesgoText;
      var1 = (var1 + (var10001 != null ? var10001.hashCode() : 0)) * 31;
      var2 = (byte)((this.permiso)? 1 : 0);
      //var2 = this.permiso;
      if (var2 != 0) {
         var2 = 1;
      }

      var1 = (var1 + var2) * 31;
      Timestamp var3 = this.duracionPermiso;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      var3 = this.lastUpdated;
      var1 = (var1 + (var3 != null ? var3.hashCode() : 0)) * 31;
      List var4 = this.resultados;
      return var1 + (var4 != null ? var4.hashCode() : 0);
   }

   public boolean equals(@Nullable Object var1) {
      if (this != var1) {
         if (var1 instanceof EncuestaUsuario) {
            EncuestaUsuario var2 = (EncuestaUsuario)var1;
            if (Intrinsics.areEqual(this.id, var2.id) && Intrinsics.areEqual(this.nombre, var2.nombre) && Intrinsics.areEqual(this.status, var2.status) && Intrinsics.areEqual(this.email, var2.email) && Intrinsics.areEqual(this.telefono, var2.telefono) && Intrinsics.areEqual(this.userUid, var2.userUid) && Intrinsics.areEqual(this.universityId, var2.universityId) && Intrinsics.areEqual(this.universityRol, var2.universityRol) && Intrinsics.areEqual(this.universitySpecialty, var2.universitySpecialty) && this.riesgo == var2.riesgo && Intrinsics.areEqual(this.riesgoText, var2.riesgoText) && this.permiso == var2.permiso && Intrinsics.areEqual(this.duracionPermiso, var2.duracionPermiso) && Intrinsics.areEqual(this.lastUpdated, var2.lastUpdated) && Intrinsics.areEqual(this.resultados, var2.resultados)) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }
}