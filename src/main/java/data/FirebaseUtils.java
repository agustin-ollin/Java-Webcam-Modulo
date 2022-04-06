package data;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseOptions.Builder;
import com.google.firebase.cloud.FirestoreClient;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JOptionPane;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
//import mx.com.divaga.covitvo.data.EncuestaUsuario;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(
        mv = {1, 5, 1},
        k = 1,
        d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J\u0006\u0010\u0011\u001a\u00020\u0006J&\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ\u0018\u0010\u0017\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\bJ(\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u001d"},
        d2 = {"Ldata/FirebaseUtils;", "", "()V", "db", "Lcom/google/cloud/firestore/Firestore;", "exec", "", "uid", "", "getEncuestaUsuarioById", "Lmx/com/divaga/covitvo/data/EncuestaUsuario;", "id", "getEncuestaUsuarioByUid", "getLastFromList", "Ldata/Encuesta;", "encuestas", "", "initFirebase", "registrarEntradaSalida", "encuestaUsuario", "date", "todayHour", "timeForHistorico", "subirEntradaSalida", "entradaSalidaHistorico", "Ldata/EntradaSalidaHistorico;", "mensaje", "updateEncuestaUsuarioEntradaSalida", "nuevoStatus", "modulo-covitvo-webcam.main"}
)
public final class FirebaseUtils {

    private Firestore db;

    @NotNull
    public final Encuesta getLastFromList(@NotNull List encuestas) {
        Intrinsics.checkNotNullParameter(encuestas, "encuestas");
        return (Encuesta) CollectionsKt.last(encuestas);
    }

    public final void initFirebase() {
        FileInputStream serviceAccount = (FileInputStream) null;

        try {
            serviceAccount = new FileInputStream("./dcea.json");
            FirebaseOptions options = (new Builder()).setCredentials(GoogleCredentials.fromStream((InputStream) serviceAccount)).setDatabaseUrl("https://deceapp-deaf2-default-rtdb.firebaseio.com").setStorageBucket("deceapp-deaf2.appspot.com").build();
            FirebaseApp.initializeApp(options);
            Firestore var10001 = FirestoreClient.getFirestore();
            Intrinsics.checkNotNullExpressionValue(var10001, "FirestoreClient.getFirestore()");
            this.db = var10001;
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    public final void exec(@NotNull final String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        BuildersKt.launch$default((CoroutineScope) GlobalScope.INSTANCE, (CoroutineContext) Dispatchers.getIO(), (CoroutineStart) null, (Function2) (new Function2((Continuation) null) {
            int label;

            @Nullable
            public final Object invokeSuspend(@NotNull Object var1) {
                Object var4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure(var1);
                        EncuestaUsuario encuestaUsuario = FirebaseUtils.this.getEncuestaUsuarioByUid(uid);
                        CharSequence var3 = (CharSequence) encuestaUsuario.getEmail();
                        if (var3.length() > 0) {
                            JOptionPane.showMessageDialog((Component) null, "EXITO");
                        } else {
                            JOptionPane.showMessageDialog((Component) null, "NO EXITO");
                        }

                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            @NotNull
            public final Continuation create(@Nullable Object value, @NotNull Continuation completion) {
                Intrinsics.checkNotNullParameter(completion, "completion");
                Function2 var3 = new <anonymous constructor > (completion);
                return (Continuation) var3;
            }

            public final Object invoke(Object var1, Object var2) {
                return ((<undefinedtype >)this.create(var1, (Continuation) var2)).invokeSuspend(Unit.INSTANCE);
            }
        }), 2, (Object) null);
    }

    @NotNull
    public final EncuestaUsuario getEncuestaUsuarioById(@NotNull String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        EncuestaUsuario encuestaUsuario = new EncuestaUsuario();
        Firestore var10000 = this.db;
        if (var10000 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("db");
        }

        DocumentReference var9 = var10000.collection("encuesta_usuario").document(id);
        Intrinsics.checkNotNullExpressionValue(var9, "db.collection(\"encuesta_usuario\").document(id)");
        DocumentReference docRef = var9;
        ApiFuture var10 = docRef.get();
        Intrinsics.checkNotNullExpressionValue(var10, "docRef.get()");
        ApiFuture future = var10;
        DocumentSnapshot document = (DocumentSnapshot) null;

        try {
            document = (DocumentSnapshot) future.get();
            String var6;
            if (document.exists()) {
                Object var11 = document.toObject(EncuestaUsuario.class);
                Intrinsics.checkNotNull(var11);
                encuestaUsuario = (EncuestaUsuario) var11;
                var6 = "nombre " + encuestaUsuario.getNombre();
                System.out.println(var6);
            } else {
                var6 = "No such document!";
                System.out.println(var6);
            }
        } catch (InterruptedException var7) {
            var7.printStackTrace();
        } catch (ExecutionException var8) {
            var8.printStackTrace();
        }

        return encuestaUsuario;
    }

    @NotNull
    public final String registrarEntradaSalida(@NotNull EncuestaUsuario encuestaUsuario, @NotNull String date, @NotNull String todayHour, @NotNull String timeForHistorico) {
        Intrinsics.checkNotNullParameter(encuestaUsuario, "encuestaUsuario");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(todayHour, "todayHour");
        Intrinsics.checkNotNullParameter(timeForHistorico, "timeForHistorico");
        String resultado = "";
        String status = encuestaUsuario.getStatus();
        String nuevoStatus = "NO ASIGNADO";
        String nuevoStatusForHistorico = "NO ASIGNADO";
        String mensaje = "NO ASIGNADO";
        if (StringsKt.contains$default((CharSequence) status, (CharSequence) "NO ASIGNADO", false, 2, (Object) null)) {
            nuevoStatus = "ENTRADA-" + date + '-' + todayHour;
            nuevoStatusForHistorico = "ENTRADA";
            mensaje = "Se registro la entrada " + todayHour;
        } else if (StringsKt.contains$default((CharSequence) status, (CharSequence) "ENTRADA", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) status, (CharSequence) date, false, 2, (Object) null)) {
            nuevoStatus = "SALIDA-" + date + '-' + todayHour;
            nuevoStatusForHistorico = "SALIDA";
            mensaje = "Se registro la salida " + todayHour;
        } else if (StringsKt.contains$default((CharSequence) status, (CharSequence) "ENTRADA", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) status, (CharSequence) date, false, 2, (Object) null)) {
            nuevoStatus = "ENTRADA-" + date + '-' + todayHour;
            nuevoStatusForHistorico = "ENTRADA";
            mensaje = "Se registro la entrada " + todayHour;
        } else if (StringsKt.contains$default((CharSequence) status, (CharSequence) "SALIDA", false, 2, (Object) null) && StringsKt.contains$default((CharSequence) status, (CharSequence) date, false, 2, (Object) null)) {
            mensaje = "YA SE HA REGISTRADO LA SALIDA EL DÍA DE HOY";
        } else if (StringsKt.contains$default((CharSequence) status, (CharSequence) "SALIDA", false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) status, (CharSequence) date, false, 2, (Object) null)) {
            nuevoStatus = "ENTRADA-" + date + '-' + todayHour;
            mensaje = "Se registro la entrada " + todayHour;
            nuevoStatusForHistorico = "ENTRADA";
        }

        String var10003 = encuestaUsuario.getUserUid();
        String var10004 = encuestaUsuario.getNombre();
        String var10005 = encuestaUsuario.getEmail();
        String var10006 = encuestaUsuario.getUniversityId();
        String var10007 = encuestaUsuario.getUniversityRol();
        String var10008 = encuestaUsuario.getUniversitySpecialty();
        String var10009 = encuestaUsuario.getRiesgoText();
        Timestamp var10013 = Timestamp.now();
        Intrinsics.checkNotNullExpressionValue(var10013, "Timestamp.now()");
        EntradaSalidaHistorico entradaSalidaHistorico = new EntradaSalidaHistorico("", var10003, var10004, var10005, var10006, var10007, var10008, var10009, nuevoStatusForHistorico, date, timeForHistorico, var10013);
        if (Intrinsics.areEqual(nuevoStatus, "NO ASIGNADO") ^ true) {
            resultado = this.updateEncuestaUsuarioEntradaSalida(encuestaUsuario, nuevoStatus, entradaSalidaHistorico, mensaje);
        }

        return resultado;
    }

    @NotNull
    public final String updateEncuestaUsuarioEntradaSalida(@NotNull EncuestaUsuario encuestaUsuario, @NotNull String nuevoStatus, @Nullable EntradaSalidaHistorico entradaSalidaHistorico, @NotNull String mensaje) {
        Intrinsics.checkNotNullParameter(encuestaUsuario, "encuestaUsuario");
        Intrinsics.checkNotNullParameter(nuevoStatus, "nuevoStatus");
        Intrinsics.checkNotNullParameter(mensaje, "mensaje");
        encuestaUsuario.setStatus(nuevoStatus);
        WriteResult result = (WriteResult) null;
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference var10000 = db.collection("encuesta_usuario").document(encuestaUsuario.getId());
        Intrinsics.checkNotNullExpressionValue(var10000, "db.collection(\"encuesta_…ument(encuestaUsuario.id)");
        DocumentReference docRef = var10000;
        ApiFuture var10 = docRef.update("status", nuevoStatus, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(var10, "docRef.update(\"status\", nuevoStatus)");
        ApiFuture future = var10;
        result = (WriteResult) future.get();
        String var9 = "ACTUALIZADO: : " + result;
        System.out.println(var9);
        return this.subirEntradaSalida(entradaSalidaHistorico, mensaje);
    }

    @NotNull
    public final String subirEntradaSalida(@Nullable EntradaSalidaHistorico entradaSalidaHistorico, @NotNull String mensaje) {
        Intrinsics.checkNotNullParameter(mensaje, "mensaje");

        try {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture addedDocRef = db.collection("entrada_salida_historico").add(entradaSalidaHistorico);
            StringBuilder var10000 = (new StringBuilder()).append("Added document with ID: ");
            Object var10001 = addedDocRef.get();
            Intrinsics.checkNotNullExpressionValue(var10001, "addedDocRef.get()");
            String var5 = var10000.append(((DocumentReference) var10001).getId()).toString();
            System.out.println(var5);
            Intrinsics.checkNotNull(entradaSalidaHistorico);
            var5 = entradaSalidaHistorico.getTipoRegistro();
            switch (var5.hashCode()) {
                case -1856382456:
                    if (var5.equals("SALIDA")) {
                        System.out.println("SALIDA REGISTRADA");
                        return mensaje;
                    }
                    break;
                case -873598409:
                    if (var5.equals("ENTRADA")) {
                        System.out.println("ENTRADA REGISTRADA");
                        return mensaje;
                    }
                    break;
                case 1347851725:
                    if (var5.equals("NO ASIGNADO")) {
                    }
            }
        } catch (InterruptedException var6) {
            var6.printStackTrace();
        } catch (ExecutionException var7) {
            var7.printStackTrace();
        }

        return "ERROR";
    }

    @NotNull
    public final EncuestaUsuario getEncuestaUsuarioByUid(@NotNull String uid) {
        Intrinsics.checkNotNullParameter(uid, "uid");
        EncuestaUsuario encuestaUsuario = new EncuestaUsuario();

        try {
            Firestore db = FirestoreClient.getFirestore();
            ApiFuture var10000 = db.collection("encuesta_usuario").whereEqualTo("userUid", uid).limit(1).get();
            Intrinsics.checkNotNullExpressionValue(var10000, "db.collection(\"encuesta_…Uid\", uid).limit(1).get()");
            ApiFuture future = var10000;
            List documents = (List) null;
            Object var13 = future.get();
            Intrinsics.checkNotNullExpressionValue(var13, "future.get()");
            documents = ((QuerySnapshot) var13).getDocuments();
            Iterator var7 = documents.iterator();

            while (var7.hasNext()) {
                QueryDocumentSnapshot document = (QueryDocumentSnapshot) var7.next();
                StringBuilder var14 = new StringBuilder();
                Intrinsics.checkNotNullExpressionValue(document, "document");
                String var8 = var14.append(document.getId()).append(" => ").append((EncuestaUsuario) document.toObject(EncuestaUsuario.class)).toString();
                System.out.println(var8);
            }

            Collection var11 = (Collection) documents;
            if (!var11.isEmpty()) {
                var13 = ((QueryDocumentSnapshot) documents.get(0)).toObject(EncuestaUsuario.class);
                Intrinsics.checkNotNullExpressionValue(var13, "documents[0].toObject(EncuestaUsuario::class.java)");
                encuestaUsuario = (EncuestaUsuario) var13;
                String var12 = encuestaUsuario.getEmail();
                System.out.println(var12);
            }
        } catch (InterruptedException var9) {
            var9.printStackTrace();
        } catch (ExecutionException var10) {
            var10.printStackTrace();
        }

        return encuestaUsuario;
    }
}
