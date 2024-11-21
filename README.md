# Program Aplikasi Pesona Wisata Samarinda
### Anggota Kelompok 9 A1
---
### Nyoman Arini Trirahayu          (2309116002)
### Diva Tri Andini                 (2309116011)  
### Aidhil Saputra                  (2309116014)
### Muhammad Hisyam Nugroho         (2309116020)
---
## 📌 Deskripsi Project
Aplikasi Pengelola Tempat Wisata Samarinda adalah platform digital berbasis Java yang dirancang untuk memudahkan pengelolaan data destinasi wisata di Samarinda. Aplikasi ini bertujuan untuk membantu admin dalam mencatat, memperbarui, dan menghapus informasi destinasi, serta memfasilitasi wisatawan untuk mencari dan mengakses informasi wisata dengan lebih mudah. Dengan memanfaatkan teknologi seperti sorting (penyortiran) dan searching (pencarian), aplikasi ini mendukung promosi wisata lokal dan memberikan pengalaman pengguna yang efisien. Aplikasi ini dibuat untuk dua jenis pengguna utama, yaitu Admin dan Pengunjung, dengan fitur dan akses yang berbeda sesuai peran masing-masing. Admin bertugas mengelola data destinasi wisata, sedangkan pengunjung dapat mengeksplorasi destinasi, memberikan rating, dan menulis ulasan.
## 📌 Fitur
### Fitur Aplikasi Pengelola Tempat Wisata Samarinda

1. **Registrasi dan Login**  
   - **Admin** dapat melakukan login akun saja.
   - **Pengunjung** dapat mendaftar untuk membuat akun baru.  
   - Login dilakukan untuk mengakses fitur aplikasi sesuai peran pengguna.

2. **Manajemen Data Wisata (CRUD) oleh Admin**  
   - **Tambah**: Menambahkan destinasi wisata baru.  
   - **Edit**: Memperbarui informasi destinasi.  
   - **Hapus**: Menghapus data destinasi.  
   - **Lihat**: Menampilkan daftar destinasi wisata.

3. **Pencarian Data**  
   - Admin dan pengunjung dapat mencari destinasi berdasarkan nama.

4. **Penyortiran Data (Sorting)**  
   - Menampilkan destinasi berdasarkan:
     - harga termurah,
     - harga termahal,
     - abjad (asc)

5. **Rating dan Ulasan**  
   - **Pengunjung** dapat memberikan rating (1-5) dan ulasan terhadap destinasi.  
   - **Admin dan pengunjung** dapat melihat hasil ulasan dan rating dari destinasi.

6. **Akses Khusus Admin**  
   - Admin dapat mengelola destinasi wisata, melihat rating dan ulasan, tetapi tidak dapat memodifikasi ulasan tersebut.  

7. **Antarmuka Pengguna**  
   - Tampilan ramah pengguna untuk admin dan pengunjung, termasuk fitur pencarian, sorting, dan navigasi data wisata.
   
## 📌 Flowchart
1.	Tampilan Pengguna
![image](https://github.com/user-attachments/assets/f422085e-7b17-4bcd-ab3b-dfef98db5872)

2.	Registrasi Pengguna
![image](https://github.com/user-attachments/assets/2fc02a1b-fd59-4124-bf10-20de4d585647)

3.	Login Admin dan Pengunjung
![image](https://github.com/user-attachments/assets/42f8a14e-0805-4710-912d-b731489615f0)

4.	Home Admin
![image](https://github.com/user-attachments/assets/3cacd107-ea66-454b-b2c0-49254fe6cf53)

5.	Menu Admin
![image](https://github.com/user-attachments/assets/414ae019-0849-4762-a39e-dd707ff6062e)

6.	Home Pengunjung
![image](https://github.com/user-attachments/assets/789bf694-dab8-4159-aafb-ac92bbda22f9)

## 📌 ERD

![image](https://github.com/user-attachments/assets/fab17ab4-4d85-4ef6-9438-801bf6fa7e7d)

## 📌 Use Case Diagram
![Cuplikan layar 2024-11-17 100156](https://github.com/user-attachments/assets/9d3d11fe-1a04-4281-b116-8a6a239b1bad)


## 📌 Struktur Project
![image](https://github.com/user-attachments/assets/80f2c360-1a8e-4e27-a461-57c48166be20)
1. Package Controller

Class **DestinasiController** bertanggung jawab untuk mengelola data destinasi wisata, dimana memiliki metode-metode sebagai berikut.
   - loadDataToTable: Membaca semua data destinasi dari database dan menampilkan di JTable.
   - tambah: Menambahkan destinasi baru ke dalam database.
   - update: Memperbarui data destinasi berdasarkan nama destinasi.
   - Menghapus data destinasi tertentu berdasarkan nama destinasi.
   - cariDestinasiWisata: Mencari destinasi berdasarkan nama yang mirip (menggunakan wildcard LIKE).
   - sortDestinasi: Mengurutkan destinasi berdasarkan pilihan, seperti harga tertinggi, harga terendah, atau abjad.

Class **RatingUlasanController** bertanggung jawab untuk mengelola fitur yang terkait dengan rating dan ulasan destinasi wisata.
   - createRatingUlasan: Menambahkan rating dan ulasan baru ke database berdasarkan input user dan memastikan destinasi yang diberikan ulasan benar-benar ada sebelum melakukan operasi penyimpanan.
   - readAllRatingUlasan: Membaca seluruh data ulasan dari database dan mengembalikan data dalam bentuk list objek RatingUlasanModel.
   - loadUlasanToTable: Menampilkan data ulasan terkait destinasi tertentu ke dalam tabel (JTable) dan memastikan tabel kosong jika data tidak ditemukan.

Class **UserController** bertanggung jawab untuk mengelola fitur autentikasi pengguna, registrasi, dan session management.
   - login: Mengecek kredensial pengguna (username dan password) dan memastikan peran pengguna (admin atau pengunjung) dan memuat data pengguna ke dalam session.
   - registerPengunjung: Menambahkan pengguna baru ke dalam database dan memastikan data pengguna valid sebelum menyimpan.
   - updateJumlahReview: Memperbarui jumlah ulasan (jumlah_review) pada tabel pengunjung berdasarkan data dari tabel rating_dan_ulasan.
   - getCurrentUser dan setCurrentUser: Mengelola session pengguna yang sedang login saat ini.
   - clearSession: Membersihkan session pengguna saat logout.

3. Package Model
   - Class **UserModel** merupakan kelas  induk (abstract) untuk semua jenis user. Metode utama class ini adalah memvalidasi kredensial login dan getters setters untuk atribut.
   - Class **Admin** merupakan turunan dari UserModel dan memiliki metode utama getter dan setter untuk atribut status yang menyimpan informasi status admin.
   - Class **Pengunjung** merupakan turunan dari UserModel dan memiiki metode utama getter dan setter untuk atribut jumlah_review yang merepresentasikan jumlah ulasan yang telah diberikan pengunjung.
   - Class **DatabaseModel** bertanggung jawab untuk mengelola koneksi ke database aplikasi dan memiliki metode utama connect untuk membuka koneksi ke database dan disconnect untuk menutup koneksi ke database.
   - Class **RatingUlasanModel** bertanggung jawab untuk merepresentasikan data ulasan pengguna terhadap destinasi.
   - Class **TableModel** bertanggung jawab untuk menambahkan data destinasi wisata ke dalam tabel GUI (Swing JTable).
   
5. Package View
   - Class **MainHome** berfungsi sebagai halaman utama (main menu) aplikasi dan menyediakan navigasi awal untuk pengguna ke halaman login atau registrasi.
   - Class **Login** berfungsi sebagai halaman untuk proses login pengguna dan memvalidasi kredensial pengguna melalui UserController.
   - Class **Registrasi** berfungsi sebagai halaman untuk proses pendaftaran akun baru untuk pengguna berperan sebagai pengunjung dan menggunakan logika dari UserController untuk menyimpan data ke database.
   - Class **HomeAdmin** berfungsi sebagai halaman utama untuk pengguna dengan peran admin dan memungkinkan admin untuk melihat daftar destinasi wisata, mengelola data destinasi, dan melihat ulasan/rating.
   - Class **MenuAdmin** berfungsi sebagai halaman untuk pengelolaan data destinasi wisata dan memungkinkan admin untuk menambahkan, mengubah, menghapus, atau memuat ulang data destinasi wisata.
   - Class **HomePengunjung** berfungsi sebagai halaman utama untuk pengguna dengan peran pengunjung dan menampilkan daftar destinasi wisata dan memungkinkan pengguna untuk melihat ulasan/rating destinasi tertentu.
   - Class **MenuPengunjung** berfungsi sebagai halaman untuk melihat ulasan/rating destinasi tertentu dan memungkinkan pengunjung untuk memberikan ulasan dan rating baru.
   
6. Libraries

## 📌 Panduan Pengunaan Program

**Tampilan awal aplikasi (User)**

 ![image](https://github.com/user-attachments/assets/735d03ba-e7ed-4632-a394-3ef1091fb25b)

Gambar 2.1 Tampilan Awal Aplikasi

	"Pada tampilan menu utama admin atau pengunjung (user) dapat login akun terlebih dulu dengan mengklik Masu, dan untuk tampilan login admin dan pengunjung (user) disatukan ditempat login yang sama, admin atau pengunjung dapat memasukan username dan password mereka, dan program akan otomnatis melakukan pengecekan apakah user tersebut login dengan role admin atau pengujung. Seperti pada gambar dibawah kanan login sebagai admin dan dibawah kiri login sebagai pengunjung."

![image](https://github.com/user-attachments/assets/fe4a5cb1-bb37-4d12-b7d6-99ec667317a0)
![image](https://github.com/user-attachments/assets/1782c90c-b61b-4d13-b509-6d6b8d79c7cf)

Gambar 2.2 Tampilan Login

"Selain login dimenu utama juga ad pilihan regitrasi jika pengunjung belum memiliki akun dengan memasukan username, password, email, dan no telepon. Mengapa pengunjung?, karena diprogram ini yang bisa melakukan registrasi akun hanya pengunjung saja, seperti gambar dibawah."

![image](https://github.com/user-attachments/assets/f69c9829-cf31-44b1-8566-43ed790f890c)
![image](https://github.com/user-attachments/assets/1a8e7929-ad3d-4778-86b8-3fd4a3205523)

Gambar 2.3 Tampilan Registrasi

Dan jika user sudah tidak ingin melakukan interaksi lagi user dapat klik tombol Keluar untuk setiap GUI nya.

**Tampilan Admin**
Jika admin ingin mengelola destinasi maka admin harus melakukan login terlebih dulu dengan catatan admin hanya dapat melakukan login, dan tidak dapat melakukan registrasi akun, jika admin berhasil login maka akan menampilkan output “Login berhasil sebagai Admin!” seperti pada gambar dibawah kiri, dan jika admin gagal login maka akan menampilkan output  “Login Gagal! username atau password salah” seperti pada gambar dibawah kanan.

![image](https://github.com/user-attachments/assets/5e941e17-c431-4213-aef1-96567c9d1f28)
![image](https://github.com/user-attachments/assets/3392e45e-bf7e-4308-8c67-77318a5955d9)

Gambar 2.4 Login Admin

Selanjutnya tampilan admin setelah berhasil login,

![image](https://github.com/user-attachments/assets/c62033b0-0d2d-468f-a37f-79c7d64a5981)

Gambar 2.5 Menu Utama Admin

Pada tampilan ini admin dapat mengelola data(CRUD), melihat data, segarkan data, melakukan searching dan sorting berdasarkan nama, harga terendah, harga tertinggi dan rating tertinggi, admin juga dapat melihat rating dan ulasan yang di berikan pengunjung. Jika admin ingin melakukan CRUD maka admin dapat mengklik tombol “Kelola Tempat Wisata” setelah itu program akan menampilkan menu CRUD admin di dalam satu halaman program aplikasi seperti pada gambar dibawah. 

![image](https://github.com/user-attachments/assets/e636ff9a-4dc1-4d09-93d1-eac52fc05ca6)

    Gambar 2.6 Tampilan Kelola Data Admin(CRUD)
    
Jika admin ingin menambahkan data tempat wisata baru (CREATE), maka admin dapat mengisi data yang sudah di sediakan seperti nama destinasi, jam operasional, deskripsi, lokasi, fasilitas dan biaya masuk. Pastikan untuk mengisi semua data destinasi dan data tidak boleh kosong,

![image](https://github.com/user-attachments/assets/38c10a3e-5d62-43b8-bc90-693493826193)

Gambar 2.7 Tambah Destinasi

Setelah semua data selesai di lengkapi selanjutnya bisa klik “Tambah Destinasi” Jika berhasil admin akan diberikan output “Data destinasi berhasil di tambahkan!” dan jika gagal atau data yang di masukan tidak sesuai maka akan diberikan output sesuai kondisi.

![image](https://github.com/user-attachments/assets/b09bb93e-44c9-4c52-af24-b0a8e0f68ef6)

Gambar 2.8 Tampilan Tambah Destinasi Berhasil

Jika admin ingin melihat data (READ) yang sudah berhasil di tambahkan atau ingin mengecek apakah data tersebut berhasil atau tidak maka admin dapat langsung melihat pada bagian tabel destinasi di list tekahir, jika data terbaru belum muncul admin dapat klik Segarkan Data, seperti gambar dibawah.

![image](https://github.com/user-attachments/assets/08b0ab54-d724-4f6c-88d5-85c40a92f228)

Gambar 2.9 Segarkan Data Setelah Tambah Destinasi

![image](https://github.com/user-attachments/assets/5ab85d56-a00a-4701-bcc5-32c95193d526)

Gambar 2.100 Lihat Destinasi

Dan jika data tempat wisata tersebut ada yang informasi terbaru maka admin dapat melakukan pembaruan data di tempat wisata tersebut, admin dapat klik tempat wisata mana yang ingin diperbarui datanya selanjutnya kolom tersebut akan otomati diisi dengan data yang lama, disini admin dapat mengubah data yang sesuai dengan informasi terbaru saat ini. 

![image](https://github.com/user-attachments/assets/01eeab52-dc61-4012-b931-b93f80355481)

Gambar 2.11 Edit Destinasi

Jika sudah sesuai admin dapat klik tombol “Edit” jika berhasil maka akan menampilkan notifikasi “Data berhasil diperbarui!” dan jika gagal maka akan  mendapatkan notifikasi sesuai kondisi.

![image](https://github.com/user-attachments/assets/19625ee3-552c-424f-9f6a-9764aeafb382)

Gambar 2.12 Tampilan Data Berhasil Edit

Selanjutnya untuk melihat data yang sudah admin edit, admin dapat klik Segarkan Data, data terbaru akan berhasil disegarkan dan data terbaru akan ditampilkan ditabel destinasi.

![image](https://github.com/user-attachments/assets/a88af13e-777f-4312-9f5b-d7d8653555f8)

Gambar 2.13 Segarkan Data Setelah Edit Destinasi

![image](https://github.com/user-attachments/assets/6d62b432-10d9-4ff9-af0b-3cbd5d2469eb)

Gambar 2.14 Lihat Destinasi Setelah di Edit

Dan jika semisalnya tempat wisata tersebut sudah tidak lagi beroperasi lagi atau sedang dalam masa perbaikan, maka admin dapat menghapus data tempat wisata dengan mengklik tempat wisata tersebut.

![image](https://github.com/user-attachments/assets/be0f2c91-96f9-431d-9d8a-a86c4dc1532d)

Gambar 2.15 Hapus Destinasi

Selanjutnya klik “Hapus” karena menghapus data merupakan suatu hal yang sensitif jadi di sini diberikan notifikasi untuk konfirmasi apakah benar data tersebut akan dihapus dari database, jika iya klik “YES” jika tidak klik “NO”. 

![image](https://github.com/user-attachments/assets/8bc5bc67-91c6-4546-9a5c-afd06f245306)

Gambar 2.16 Tampilan Konfirmasi Hapus

Gambar dibawah kiri ini adalah tampilan jika admin klik “YES” untuk mengkonfirmasi penghapusan data, dan gambar dibawah kanan ini adalah tampilan jika admin klik “NO” untuk membantalkan penghapusan data.

![image](https://github.com/user-attachments/assets/4a87bb08-3ba2-4fb9-9391-07f214242aa9)

![image](https://github.com/user-attachments/assets/59b825aa-ae1c-4af0-bce8-ae09e2fe2182)

Gambar 2.17 Tampilan Konfirmasi YES dan NO

Pengecekan apakah data wisata Taman Cerdas sudah terhapus dari tabel destinasi, admin dapat mengeck di baris tabel, seperti pada gambar dibawah tabel destinasi sudah tidak menampilkan destinasi wisata Taman Cerdas lagi ini artinya penghapusan data berhasil, sedangkan tempat wisata Kapal Wisata Mahakam masi adapada tabel destinasi ini artinya pembatalan saat pengkonfirmasiaan data juga berhasil.

![image](https://github.com/user-attachments/assets/e2e394fe-e88c-420f-be4b-2e583fd8bef5)

Gambar 2.18 Lihat Destinasi Setelah di Hapus

Selanjutnya admin juga dapat melakukan pencarian tempat wisata dengan mengetikkan nama tempat wisata pada kolom pencarian setelah itu admin dapat menekan tombol “OK” maka tabel destinasi akan menampilkan tempat wisata yang sedang dicari seperti gambar dibawah.

![image](https://github.com/user-attachments/assets/bd2994e5-ca65-47ac-838a-5f88d2286167)

Gambar 2.19 Pencarian Destinasi Admin (Searching)

Selain searching admin juga dapat melakukan sorting dimana admin dapat mengurutkan data berdasarkan harga tertinggi, harga terendah, dan abjad A-Z (ascanding), seperti gambar dibawah.

![image](https://github.com/user-attachments/assets/a2a3fbd5-3c23-4a32-90fe-199255b25507)

Gambar 2.20 Menu Pengurutan Destinasi Admin (Sorting)

Admin dapat memilih salah salah satu dari pilihan sorting  didalam combo box tersebut setelah memilih maka data akan otomatis menampilkan hasil sorting berdasarkan kondisi yang diinginkan admin, seperti gambar dibawah.


![image](https://github.com/user-attachments/assets/bda453dd-ffcd-4462-bef0-c75ef7dfa799)

Gambar 2.21 Sorting Berdasarkan Harga Tertinggi Admin


![image](https://github.com/user-attachments/assets/423bb50d-d33e-4299-929e-7a59c2737e9c)


Gambar 2.22 Sorting Berdasarkan Harga Terendah Admin

![image](https://github.com/user-attachments/assets/a40a831e-a221-4c2f-af16-1d1d14771ec1)

Gambar 2.23 Sorting Berdasarkan abjad A-Z Admin


Selain itu di sini admin dapat melihat rating dan ulasan yang di berikan oleh pengunjung mengenai tempat wisata yang telah di kunjunginya, admin bisa memilih tempat wisata mana yang akan dilihat rating dan ulasannya selanjutnya admin dapat klik “Lihat Rating dan Ulasan”.

![image](https://github.com/user-attachments/assets/c039ed2c-c2a5-4faf-a67a-f2d5ddb92a9e)

Gambar 2.24 Lihat Rating dan Ulasan Admin

Selanjutnya, maka admin dapat melihat rating dan ulasannya tetapi di sini admin tidak dapat membuat, mengedit dan menghapus data pada rating dan ulasan, dan jika sudah selesai melihat ulasan admin dapat kembali kemenu admin.

![image](https://github.com/user-attachments/assets/10dba7a6-7f5f-4b8a-be89-e37655af4bc6)

Gambar 2.25 Tampilan Rating dan Ulasan Admin


**Tampilan Pengunjung**
Jika pengunjung ingin memberikan rating dan ulasan pada tempat wisata maka pengunjung dapat melakukan login atau registrasi akun terlebih dulu. Untuk tampilan login pengunjung bisa memasukan username dan password yang sudah terdaftar jika berhasil login maka akan menampilkan output “Login berhasil sebagai Pengunjung!” seperti pada gambar dibawah kiri, dan jika pengujung belum punya akun atau gagal melakukan login maka akan menampilkan output “Login Gagal! Username atau Password salah.” seperti pada gambar dibawah kanan.

![image](https://github.com/user-attachments/assets/ec2c5b24-1f0e-4f82-9b30-85b1a1af3f7b)

![image](https://github.com/user-attachments/assets/642f6a49-9e88-4db0-af2f-53f3889e0f23)

Gambar 2.26 Login Pengunjung

Untuk tampilan registrasi akun pengunjung, pengunjung diminta untuk memasukan username, password, email dan nomer telepon. Data wajib di isi semua dan tidak boleh kosong. Isi data sesuai dengan kolom seperti pada gambar dibawah kiri, jika berhasil registrasi akun maka akan menampilkan output “Registrasi Berhasil! Silahkan Login.” seperti pada gambar dibawah kanan.

![image](https://github.com/user-attachments/assets/973bb340-271e-4489-9589-d3f4d5148e07)

![image](https://github.com/user-attachments/assets/aeb14fd3-688d-4646-85ec-bbd0c4c587b2)

Gambar 2.27 Registrasi Pengunjung

Setelah itu jika pengunjung sudah berhasil membuat akun maka pengunjung akan ditampilkan halaman login, di sini pengunjung dapat memasukan username dan password yang baru saja dibuat saat registrasi akun pengunjung seperti pada gambar dibawah.

![image](https://github.com/user-attachments/assets/7b3c9bed-ccfa-497c-8a33-fec1000eadca)

Gambar 2.28 Login setelah Registrasi Pengunjung

Jika pengunjung sudah berhasil melakukan login maka pengunjung akan ditampilkan menu pengunjung disini pengunjung dapat melakukan searching, sorting, melihat data destinasi wisata disamarinda, dan pengunjung juga dapat memberikan penilaian atau pengalamannya untuk destinasi wisata tersebut, seperti pada gambar dibawah ini.


![image](https://github.com/user-attachments/assets/0cc77107-b9c0-4243-b80d-8b51080b819a)

Gambar 2.29 Menu Pengunjung

Dan jika pengunjung ingin mencari tempat wisata tertentu maka pengunjung dapat mengetik nama tempat wisata yang di cari contoh “betapus” selanjutnya pengunjung dapat menekan tombol OK setelah itu akan ditampilkan tempat wisata yang sedang dicari serta rinciannya, seperti gambar dibawah ini.

![image](https://github.com/user-attachments/assets/e95300ff-0088-4692-8bc3-393b29b56cb9)

Gambar 2.30 Pencarian Destinasi Pengunjung (Searching)

Dan jika pengunjung ingin mengurutkan tempat wisata yang tersedia yaitu wisata berdasarkan harga tertinggi, harga terendah, dan abjad A-Z(asc), pengunjung dapat langsung memilih kondisi yang di inginkan di dalam combo box yang tersedia, setelah memilih maka tabel akan otomatis memberikan output sesuai dengan kondisi yang diberikan, seperti gambar dibawah ini.

![image](https://github.com/user-attachments/assets/fc299dc0-15ce-47de-8f2a-143ef2538cc0)

Gambar 2.31 Menu Pengurutan Destinasi Pengunjung (Sorting)

![image](https://github.com/user-attachments/assets/7460d236-9639-4703-88cf-be8b36eb07af)

Gambar 2.32 Sorting Berdasarkan Abjad A-Z Pengunjung

![image](https://github.com/user-attachments/assets/554f362b-3666-497f-896c-98ff64a18855)

Gambar 2.33 Sorting Berdasarkan Harga Terendah Pengunjung

![image](https://github.com/user-attachments/assets/5e2abb3d-ec43-43d7-874d-245081e781fb)

Gambar 2.34 Sorting Berdasarkan Harga Tertinggi Pengunjung

Pengunjung juga bisa melihat dan membuat rating ulasan untuk destinasi, untuk melihat rating dan ulasan pengunjung harus memilih tempat wisata yang ingin dilihat atau membuat rating dan ulasannnya, selanjutnya klik Lihat “Rating dan Ulasan” , pada tampilan ini pengunjung akan ditampilkan rating dan ulasan ditempat wisata tersebut, seperti gambar dibawah.

![image](https://github.com/user-attachments/assets/5e2e3ac0-fca1-47b5-9362-5838a615fb5e)

Gambar 2.35 Lihat Rating dan Ulasan Pengunjung

![image](https://github.com/user-attachments/assets/bafb87d5-2e88-4fae-937b-dbccf6cc9bdb)

Gambar 2.36 Tampilan Rating dan Ulasan Pengunjung

Jika pengunjung ingin memberikan rating dan ulasan pengunjung dapat memilih tempat wisata yang akan di berikan rating dan ulasan setelah klik pengguna diminta untuk mengisi ulasan dan menginputkan rating nilai 1-5 mengenai tempat tersebut. Jika sudah terisi semua klik “Buat Rating dan Ulasan”, seperti gambar dibawah.
  
![image](https://github.com/user-attachments/assets/884faccc-7ea4-41c3-ad76-6d0f339a2040)

![image](https://github.com/user-attachments/assets/6a56aaa8-fa23-4f6d-8311-944bc7a412b2)

Gambar 2.37 Tambah Rating dan Ulasan Pengunjung

Setelah itu pengunjung bisa melihat hasil ulasan akan terkirim dan langsung di tampilkan pada tabel rating dan ulasan tempat wisata tersebut.

![image](https://github.com/user-attachments/assets/d9f70442-bf55-40f2-9a94-d764a2eb03ca)

Gambar 2. 48 Lihat Rating dan Ulasan setelah di Tambahkan Pengunjung
