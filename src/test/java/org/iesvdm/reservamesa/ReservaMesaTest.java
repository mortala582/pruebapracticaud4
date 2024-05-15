package org.iesvdm.reservamesa;

//import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReservaMesaTest {
    private int[] array;


    @Test
    void rellenarMesaTest() {
    //debo probar que no meta mas de 4 en mesa y que sea mayor que 0
        int menor = 0;
        int mayor = 4;
        ReservaMesa reservaMesa = new ReservaMesa();

        reservaMesa.setTamanioMesa(4);

        int[] mesas = new int[5];
        reservaMesa.setMesas(mesas);

        reservaMesa.rellenarMesas();
        for (int i = 0; i < mesas.length; i++) {
            assertThat(mesas[i]).isGreaterThan(menor);
            assertThat(mesas[i]).isLessThanOrEqualTo(mayor);
        }


    }
    @Test
    void buscarPrimeraMesaVaciaTest(){
        ReservaMesa reservaMesa = new ReservaMesa();
        int[] mesas = new int[3];
        mesas[0] = 1;
        mesas[1] = 0;
        mesas[2] = 3;
        reservaMesa.setMesas(mesas);
        int mesaVacia=reservaMesa.buscarPrimeraMesaVacia();


        assertThat(mesaVacia).isEqualTo(1);

    }
    @Test
    void buscarMesaParaCompartirTest(){
        ReservaMesa reservaMesa = new ReservaMesa();
        reservaMesa.setTamanioMesa(4);
        int[] mesas = new int[3];
        mesas[0] = 1;
        mesas[1] = 0;
        mesas[2] = 3;
        reservaMesa.setMesas(mesas);
        int mesaCompartir=reservaMesa.buscarMesaParaCompartir(3);
        assertThat(mesaCompartir).isEqualTo(0);

    }
    @Test
    void buscarMesaCompartirMasCercaDeTest(){
        ReservaMesa reservaMesa = new ReservaMesa();
        reservaMesa.setTamanioMesa(4);
        int[] mesas = new int[4];
        mesas[0] = 1;
        mesas[1] = 0;
        mesas[2] = 3;
        mesas[3] = 1;
        reservaMesa.setMesas(mesas);
        int mesaCercana=reservaMesa.buscarMesaCompartirMasCercaDe(2, 2);
        assertThat(mesaCercana).isEqualTo(1);

    }
    @Test
    void buscarMesaCompartirMasAlejadaDeTest(){
        ReservaMesa reservaMesa = new ReservaMesa();
        reservaMesa.setTamanioMesa(4);
        int[] mesas = new int[4];
        mesas[0] = 1;
        mesas[1] = 0;
        mesas[2] = 3;
        mesas[3] = 1;
        reservaMesa.setMesas(mesas);
        int mesaLejos=reservaMesa.buscarMesaCompartirMasAlejadaDe(2, 3);
        assertThat(mesaLejos).isEqualTo(0);
    }
    @Test
    void buscarCompartirNMesasConsecutivas(){

        // falla, siempre devuelve 0

        ReservaMesa reservaMesa = new ReservaMesa();
        reservaMesa.setTamanioMesa(4);
        int[] mesas = new int[4];
        mesas[0] = 1;
        mesas[1] = 0;
        mesas[2] = 3;
        mesas[3] = 1;
        reservaMesa.setMesas(mesas);

       int mesasalida=reservaMesa.buscarCompartirNMesasConsecutivas(2,4);
       assertThat(mesasalida).isEqualTo(1);


    }
    @Test
    void comensalesTotalesTest(){
        ReservaMesa reservaMesa = new ReservaMesa();
        reservaMesa.setTamanioMesa(4);
        int[] mesas = new int[4];
        mesas[0] = 1;
        mesas[1] = 0;
        mesas[2] = 3;
        mesas[3] = 1;
        reservaMesa.setMesas(mesas);
        int mesaTotales=reservaMesa.comensalesTotales();
        assertThat(mesaTotales).isEqualTo(5);


    }
}