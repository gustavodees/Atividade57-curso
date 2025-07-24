package principal;


import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static java.lang.Character.getName;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Digite com o nome do departamento: ");
        String departamentName = sc.nextLine();
        System.out.println("Digite os dados do trabalhador: ");
        System.out.print("Nome: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workerLevel = sc.nextLine();
        System.out.print("Salario Base: ");
        double baseSalary = sc.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Departament(departamentName));

        System.out.print("Quantos contratos este trabalhador vai ter: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Digite o contrato #" + (i + 1) + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());
            System.out.print("Valor por hora: ");
            double valuePerHour = sc.nextDouble();
            System.out.print("Duração ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Digite mês e ano para calcular o valor total: (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Nome: "+ worker.getName());
        System.out.println("Departamento: "+ worker.getDepartament().getNome());
        System.out.println("Salario: "+ monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));


        sc.close();
    }
}