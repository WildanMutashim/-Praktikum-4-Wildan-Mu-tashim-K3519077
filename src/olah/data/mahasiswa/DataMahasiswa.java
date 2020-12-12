/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olah.data.mahasiswa;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
/**
 *
 * @author Wildan Mu'tashim
 */
public class DataMahasiswa {
    int pilihMenu;
    int Konfirmasi;
    ArrayList<String> daftarNim = new ArrayList<String>();
    ArrayList<String> daftarNama = new ArrayList<String>();
    ArrayList<Date> ttl = new ArrayList<Date>();
    ArrayList<Integer> jenisKelamin = new ArrayList<Integer>();
    Scanner inputData = new Scanner(System.in);
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
    void menu(){
        Scanner n=new Scanner(System.in);
        System.out.println("Menu \n1. Tambah Data \n2. Hapus Data \n3. Cari Data \n4. Tampilkan Data");
        System.out.println("----------------------");        
        this.pilihMenu = n.nextInt();
        
        if(pilihMenu == 1){
            tambahData();
        }
        else if(pilihMenu == 2){
            hapusData();
        }
        else if(pilihMenu == 3){
            cariData();
        }
        else if(pilihMenu == 4){
            tampilkanData();
        }
        else{
            System.out.println("Maaf, pilihan yang anda masukan salah silahkan pilih menu 1 sampai dengan 4");
            System.out.println("============================================= \n");
            menu();
        }
    }

    void tambahData(){
        do{
        String nim,nama;
        Integer gender;
        int tahun,hari,bulan;
        
        System.out.println("\nMasukkan Data Mahasiswa:");
        System.out.print("NIM: ");
        nim = inputData.nextLine();
        System.out.print("Nama: ");
        nama = inputData.nextLine();
        System.out.println("Tanggal Lahir (dd/mm/yyyy): ");
        System.out.print(" Tanggal : ");
        hari = inputData.nextInt();
        System.out.print(" Bulan : ");
        bulan = inputData.nextInt();
        System.out.print(" Tahun : ");
        tahun = inputData.nextInt();
        Date tanggal = new GregorianCalendar(tahun, bulan - 1, hari).getTime();
        System.out.print("Gender (0:Perempuan 1:Laki-laki): ");
        gender = inputData.nextInt();
        daftarNim.add(nim);
        daftarNama.add(nama);
        ttl.add(tanggal);
        jenisKelamin.add(gender);
        
        System.out.println("Apakah anda ingin menambahkan data lagi? \n1. Ya \n2. Tidak");
        System.out.println("----------------------\n");        
        Scanner n=new Scanner(System.in);        
        this.Konfirmasi = n.nextInt();
        
        }while (Konfirmasi == 1);
        menu();
    }        
    
    void hapusData(){
        if(daftarNim.size() > 0){
            System.out.print("Masukkan NIM: ");
            String terhapus = inputData.nextLine();
            inputData.nextLine();
            int index = daftarNim.indexOf(terhapus);
            if(index < 0){
                System.out.println("===========================");
                System.out.println("DATA TIDAK DAPAT DITEMUKAN.");
                System.out.println("===========================");
            }
            else{
                daftarNim.remove(index);
                daftarNama.remove(index);
                ttl.remove(index);
                jenisKelamin.remove(index);
                System.out.println("=====================");
                System.out.println("DATA BERHASIL DIHAPUS.");
                System.out.println("=====================");
            }
        }
        else{
            System.out.println("============");
            System.out.println("DATA KOSONG.");
            System.out.println("============");
        }        
    }
    void cariData(){
        System.out.println("Cari Data Berdasarkan : ");
        System.out.println(" 1. NIM \n 2. Gender");
        System.out.print("Masukkan Pilihan: ");
        int pilihan = inputData.nextInt();
        switch(pilihan){
            case 1:
                inputData.nextLine();
                System.out.print("  Masukkan NIM : ");
                String dicari = inputData.nextLine();
                for(String n: daftarNim){
                    if(daftarNim.contains(dicari)){
                        int index = daftarNim.indexOf(dicari);
                        String tgllahir = formatter.format(ttl.get(index));
                        String jenisKel = (jenisKelamin.get(index) == 0) ? "Perempuan" : "Laki-laki";
                        System.out.println("=======================");
                        System.out.println("Mahasiswa NIM " + daftarNim.get(index));
                        System.out.println("=======================");
                        System.out.println("NIM : " + daftarNim.get(index));
                        System.out.println("Nama : " + daftarNama.get(index));
                        System.out.println("Tanggal Lahir : " + tgllahir);
                        System.out.println("Gender : " + jenisKel);
                        System.out.println("=======================");
                        break;
                    }
                }
                break;
            case 2:
                inputData.nextLine();
                System.out.print("  Masukkan Gender(0:Perempuan 1:Laki-laki):");
                int dicari2 = inputData.nextInt();
                for(int n = 0; n < jenisKelamin.size(); n++){
                    if(jenisKelamin.get(n) == dicari2){
                        String tgllahir = formatter.format(ttl.get(n));
                        String jenisKel = (jenisKelamin.get(n) == 0) ? "Perempuan" : "Laki-laki";
                        System.out.println("=======================");
                        System.out.println("Data Berdasarkan Gender");
                        System.out.println("=======================");
                        System.out.println("NIM : " + this.daftarNim.get(n));
                        System.out.println("Nama : " + this.daftarNama.get(n));
                        System.out.println("Tanggal Lahir : " + tgllahir);
                        System.out.println("Gender : " + jenisKel);
                        System.out.println("=======================");
                    }
                };
                break;
            default:
                System.out.println("====================================");
                System.out.println("Menu Yang Anda Pilih Tidak Tersedia.");
                System.out.println("====================================");
        }        
    }
    void tampilkanData(){
        if(daftarNim.size() == 0){
            System.out.println("===============");
            System.out.println("TIDAK ADA DATA.");
            System.out.println("===============");
        }else{
            for(int n = 0; n < daftarNim.size(); n++){
                String tgllahir = formatter.format(ttl.get(n));
                String jenisKel = (jenisKelamin.get(n) == 0) ? "Perempuan" : "Laki-laki";
                System.out.println("====================");
                System.out.println("    No" + (n+1));
                System.out.println("====================");
                System.out.println("NIM : " + daftarNim.get(n));
                System.out.println("Nama : " + daftarNama.get(n));
                System.out.println("Tanggal : " + tgllahir);
                System.out.println("Gender : " + jenisKel);
                System.out.println("====================");
            }
            System.out.println("Jumlah Seluruh Mahasiswa : " + daftarNim.size() +"\n");
        }        
    }
}
