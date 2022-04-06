package data;

import com.google.cloud.Timestamp;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(
   mv = {1, 5, 1},
   k = 1,
   d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"},
   d2 = {"Ldata/DateConverterUtils;", "", "()V", "getDateString", "", "fecha", "Lcom/google/cloud/Timestamp;", "getDateStringPLUS1", "getDateTimeString", "getDateTimeStringForHistorico", "modulo-covitvo-webcam.main"}
)
public final class DateConverterUtils {
   @NotNull
   public final String getDateString(@NotNull Timestamp fecha) {
      Intrinsics.checkNotNullParameter(fecha, "fecha");
      Date var10000 = fecha.toDate();
      Intrinsics.checkNotNullExpressionValue(var10000, "fecha.toDate()");
      Date dateActual = var10000;
      Calendar calActual = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(calActual, "calActual");
      calActual.setTime(dateActual);
      int dayActual = calActual.get(5);
      int monthActual = calActual.get(2);
      int yearActual = calActual.get(1);
      return "" + dayActual + '-' + monthActual + '-' + yearActual;
   }

   @NotNull
   public final String getDateStringPLUS1(@NotNull Timestamp fecha) {
      Intrinsics.checkNotNullParameter(fecha, "fecha");
      Date var10000 = fecha.toDate();
      Intrinsics.checkNotNullExpressionValue(var10000, "fecha.toDate()");
      Date dateActual = var10000;
      Calendar calActual = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(calActual, "calActual");
      calActual.setTime(dateActual);
      int dayActual = calActual.get(5);
      int monthActual = calActual.get(2);
      int yearActual = calActual.get(1);
      return "" + dayActual + '-' + (monthActual + 1) + '-' + yearActual;
   }

   @NotNull
   public final String getDateTimeString(@NotNull Timestamp fecha) {
      Intrinsics.checkNotNullParameter(fecha, "fecha");
      Date var10000 = fecha.toDate();
      Intrinsics.checkNotNullExpressionValue(var10000, "fecha.toDate()");
      Date dateActual = var10000;
      Calendar calActual = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(calActual, "calActual");
      calActual.setTime(dateActual);
      int dayActual = calActual.get(5);
      int monthActual = calActual.get(2);
      int yearActual = calActual.get(1);
      int hora = calActual.get(11);
      int minutos = calActual.get(12);
      return "A LAS " + hora + " HORAS CON " + minutos + " MINUTOS";
   }

   @NotNull
   public final String getDateTimeStringForHistorico(@NotNull Timestamp fecha) {
      Intrinsics.checkNotNullParameter(fecha, "fecha");
      Date var10000 = fecha.toDate();
      Intrinsics.checkNotNullExpressionValue(var10000, "fecha.toDate()");
      Date dateActual = var10000;
      Calendar calActual = Calendar.getInstance();
      Intrinsics.checkNotNullExpressionValue(calActual, "calActual");
      calActual.setTime(dateActual);
      int dayActual = calActual.get(5);
      int monthActual = calActual.get(2);
      int yearActual = calActual.get(1);
      int hora = calActual.get(11);
      int minutos = calActual.get(12);
      return "" + hora + ':' + minutos;
   }
}
