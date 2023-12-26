import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; 

class penjualan  extends pelanggan{
  static Integer kodeBarang=0;
   public String namabarang;
   public Integer hargabarang;
   public Integer jumlahbeli;
   public Integer totalBayar;  
   public String kasir;

   public penjualan(String nama, String alamat, String namabarang, String kasir, Integer hargabarang, 
     Integer jumlahbeli) {
      super(nama, alamat);
      this.alamat = alamat;
      this.kasir=kasir;
      this.namabarang = namabarang;
      this.hargabarang = hargabarang;
      this.jumlahbeli = jumlahbeli;
      totalBayar = hargabarang*jumlahbeli;
      cetakFaktur();
   }
   @Override
   public void cetakFaktur(){
   
      System.out.println("\nDREAM SUPERMART");
            DateTimeFormatter tgl = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime lv = LocalDateTime.now();
        for(int pls = 1; pls <= 20; pls++){
      System.out.print("-=");
   }
      System.out.println("\nTanggal    : " + tgl.format(lv));
            DateTimeFormatter wkt = DateTimeFormatter.ofPattern("HH:m:ss");
      System.out.println("Waktu    : " + wkt.format(lv) + "WIB" + "\n");
      
   
System.out.println("\nDATA PELANGGAN");
   
   System.out.print("Nama Pelanggan: "+ nama) ;
   
   System.out.println("\nAlamat        : "+ super.alamat + "\n");   
      for(int pls = 1; pls <= 20; pls++){
         System.out.print("+");
     }

   System.out.println("\nDATA PEMBELIAN BARANG");
   for(int min2 =1; min2<= 20; min2++){
      System.out.print("-");
   }

   System.out.print("\nKode Barang     :N-" + kodeBarang);
   System.out.print("\nNama Barang     : " + namabarang);
   System.out.print("\nHarga Barang    :Rp " + hargabarang);
   System.out.print("\nJumlah Beli     : " + jumlahbeli + " buah");
   System.out.print("\nTOTAL BAYAR     :Rp " + totalBayar+ "\n");
   for(int pls = 1; pls <= 30; pls++){
      System.out.print("+");
   }

   System.out.print("\nKasir           : " + kasir);
}
}
