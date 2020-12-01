package com.sergiojavierre;

import com.sergiojavierre.modelos.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;

public class GestorEstudiantes {

    private List<Estudiante> estudiantes;
    private TreeMap<Integer,List<Estudiante>> notas1Parcial, notas2Parcial;

    public GestorEstudiantes() {
        this.estudiantes = new ArrayList<>();
        this.notas1Parcial = new TreeMap<>();
        this.notas2Parcial = new TreeMap<>();
    }

    public void creaEstudiantes(){
        String[] nombres = {"Ana","Eva","Juan","Igor","Vero","Sergio","Sara","Elena","Fernando","Pablo"};
        String[] apellidos = {"Pérez","Sánchez","Martínez","López","Giménez","Sáez","González","Ruiz","Gómez","Fernández"};
        Random random = new Random();
        for(int i = 0; i < 100; i++){
            int indexNombre = random.nextInt(10);
            int indexApellido = random.nextInt(10);
            Estudiante estudiante = new Estudiante(nombres[indexNombre],apellidos[indexApellido]);
            this.estudiantes.add(estudiante);
            int nota1Parcial = random.nextInt(100);
            int nota2Parcial = random.nextInt(100);
            setNotas(estudiante,nota1Parcial,notas1Parcial);
            setNotas(estudiante,nota2Parcial,notas2Parcial);
        }
    }

    public void setNotas(Estudiante estudiante, Integer nota, TreeMap<Integer,List<Estudiante>> parcial){
        parcial.computeIfAbsent(nota, k -> new ArrayList<>());
        parcial.get(nota).add(estudiante);
    }

    public void showNotas(){
        System.out.println(notas1Parcial);
        System.out.println(notas2Parcial);
    }
}
