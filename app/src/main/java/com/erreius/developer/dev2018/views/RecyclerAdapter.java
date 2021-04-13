package com.erreius.developer.dev2018.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.erreius.developer.dev2018.Model.Codigo;
import com.erreius.developer.dev2018.Model.CodigosResponse;
import com.erreius.developer.dev2018.Model.EncryptData;
import com.erreius.developer.dev2018.Model.User;
import com.erreius.developer.dev2018.R;
import com.erreius.developer.dev2018.interfaces.MainContract;
import com.erreius.developer.dev2018.presenters.MainPresenter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;
import static com.erreius.developer.dev2018.views.RegistrarP1Fragment.MY_PREFS_NAME;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HolderView> implements  MainContract.View{
    Context context;
    List<CodigosResponse> notasList;
    public MainPresenter mPresenter;
    public NotasFragment notasFragment;
    public RecyclerAdapter(Context context, List<CodigosResponse> mainList,NotasFragment fragment) {
        this.context = context;
        this.notasList = mainList;
        this.notasFragment = fragment;
    }

    @NonNull
    @Override
    public RecyclerAdapter.HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycleview_row, parent,false);
        mPresenter = new MainPresenter(this);
        CardView card_view =  (CardView) view.findViewById(R.id.card_view);
        card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);

                LayoutInflater inflater = LayoutInflater.from(context);
                View dialogView = inflater.inflate(R.layout.detalle, null);

                TextView texto = dialogView.findViewById(R.id.txtContenidoNota);
                TextView textoTitulo = dialogView.findViewById(R.id.textView6);
                TextView contenido = view.findViewById(R.id.txtTemp);
                TextView contenidoTitulo = view.findViewById(R.id.txtType);
                TextView idNota = view.findViewById(R.id.idNota);
                texto.setText(contenido.getText().toString());
                texto.setText(texto.getText().toString());
                textoTitulo.setText(textoTitulo.getText() + contenidoTitulo.getText().toString() );
                texto.setEnabled(false);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setPositiveButton("Borrar Nota", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Codigo codigo = new Codigo();
                        codigo.setIdNota(Integer.valueOf(idNota.getText().toString()));
                        mPresenter.eliminarnota(codigo);
                    }
                });
                dialogBuilder.setNegativeButton("Cerrar",null );
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
        return new HolderView(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.HolderView holder, int position) {
        holder.cardView.setTag(position);
        holder.type.setText(notasList.get(0).lista.get(position).getTituloCodigo());
        holder.temp.setText(notasList.get(0).lista.get(position).getNota());
        holder.idNota.setText(String.valueOf(notasList.get(0).lista.get(position).getIdNota()));
    }

    @Override
    public int getItemCount() {
        return notasList.get(0).lista.size();
    }

    @Override
    public void onCreatePlayerSuccessful() {

    }

    @Override
    public void onCreatePlayerFailure() {

    }

    @Override
    public void onProcessStart() {

    }

    @Override
    public void onProcessEnd() {

    }

    @Override
    public void onUserRead(User user) {

    }

    @Override
    public void onUserCreate(User user) {

    }

    @Override
    public void onEncryptData(EncryptData encryptData) {

    }

    @Override
    public void onGuardarNota(Codigo codigo) {
        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Integer mIdUser = prefs.getInt("idUser", 0);
        codigo.setIdUser(mIdUser);
        notasFragment.CallNotas(codigo);
    }

    @Override
    public void onObtenerNotas(CodigosResponse codigos) {

    }

    public class HolderView extends RecyclerView.ViewHolder {
        TextView temp;
        TextView type;
        TextView idNota;
        CardView cardView;
        public HolderView(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            type = itemView.findViewById(R.id.txtType);
            temp = itemView.findViewById(R.id.txtTemp);
            idNota = itemView.findViewById(R.id.idNota);
        }
    }
}
