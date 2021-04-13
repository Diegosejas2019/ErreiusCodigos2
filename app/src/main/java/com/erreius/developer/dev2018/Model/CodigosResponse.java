package com.erreius.developer.dev2018.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CodigosResponse {
    @SerializedName("Specialities")
    public ArrayList<Specialities> lista = new ArrayList<>();


        public class Specialities {
            public int IdUser;

            public String Codigo;

            public String CodigoQr;

            public String TituloCodigo;

            public String Nota;

            public int IdNota;


            public int getIdUser() {
                return IdUser;
            }

            public void setIdUser(int idUser) {
                IdUser = idUser;
            }

            public String getCodigo() {
                return Codigo;
            }

            public void setCodigo(String codigo) {
                Codigo = codigo;
            }

            public String getCodigoQr() {
                return CodigoQr;
            }

            public void setCodigoQr(String codigoQr) {
                CodigoQr = codigoQr;
            }

            public String getTituloCodigo() {
                return TituloCodigo;
            }

            public void setTituloCodigo(String tituloCodigo) {
                TituloCodigo = tituloCodigo;
            }

            public String getNota() {
                return Nota;
            }

            public void setNota(String nota) {
                Nota = nota;
            }

            public int getIdNota() {
                return IdNota;
            }

            public void setIdNota(int idNota) {
                IdNota = idNota;
            }
        }

}
