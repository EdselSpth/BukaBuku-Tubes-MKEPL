# BukaBuku - E-Book Platform (Tugas Besar MKEPL)

## 1. Deskripsi Singkat Proyek
BukaBuku adalah sebuah platform manajemen E-Book berbasis *Command Line Interface* (CLI) yang dikembangkan menggunakan bahasa pemrograman Java. Aplikasi ini memfasilitasi dua peran pengguna:
- **Admin**: Dapat melakukan manajemen data buku (tambah, hapus, edit) dengan berbagai kategori (Pendidikan, Sejarah, Novel, Komik, Majalah).
- **User**: Dapat melihat daftar buku, mencari e-book, membeli buku, membaca buku di perpustakaan pribadi, hingga memberikan komentar atau melakukan *refund*.

## 2. Arsitektur Pipeline CI/CD
Proyek ini mengimplementasikan alur CI/CD secara otomatis menggunakan **GitHub Actions** dengan file konfigurasi `.github/workflows/maven.yml`. Strategi *branching* memisahkan pengerjaan di branch `feature/**` dan `develop`, yang kemudian akan di-*merge* ke `main`.

Arsitektur pipeline mencakup komponen berikut:
* **Continuous Integration (CI):** Setiap kali terdapat *push* atau *pull request* ke branch `main`, `develop`, atau `feature/**`, GitHub Actions akan menyiapkan environment JDK 23 dan melakukan build proyek secara otomatis menggunakan Maven (`mvn -B clean package`). Status kesuksesan atau kegagalan build akan langsung dilaporkan.
* **Continuous Testing (CT):** Pengujian otomatis dengan JUnit dieksekusi setelah proses *build* Maven. Jika ada tes yang gagal, maka proses pipeline akan terhenti.
* **Continuous Inspection:** Setelah proses build selesai, kode dianalisis kualitasnya secara statis menggunakan **SonarCloud**. Laporan *quality gate* dan inspeksi kode dikirim ke SonarCloud menggunakan *secrets* token repositori. Apabila kode tidak memenuhi standar kualitas, pipeline cicd akan gagal.
* **Continuous Delivery (CD):** Proyek ini menggunakan pendekatan *Continuous Delivery*. Proses *deploy* dipicu ketika terjadi *pull request* yang ditargetkan ke branch `main` (`github.base_ref == 'main'`) dan ketika *job build* sebelumnya telah sukses. Perpindahan ke production (main) masih memerlukan *review* dan persetujuan PR secara manual.

## 3. Pembagian Tugas Anggota Kelompok

| Nama Anggota | NIM | Tanggung Jawab (Fitur & Pipeline) |
| :--- | :--- | :--- |
| Edsel Septa Haryanto | 103022300016 | Setup maven, github secret, github action, Continous Inspection |
| Tio Funny Tinambunan | 103022330036 | Continous Testing |
| Raditya Maheswara Putra | 103022330026 | Continous Integration |
| Dewanta Rahma Satria | 1030223 | Continous Delivery |

## 4. Tools dan Teknologi yang Digunakan
Berikut adalah daftar teknologi yang dimanfaatkan pada setiap tahapan pipeline:
* **Bahasa Pemrograman:** Java (JDK 23)
* **Package Manager & Build Tool:** Apache Maven
* **Continuous Integration & Testing:** GitHub Actions & JUnit (versi 4.11)
* **Continuous Inspection:** SonarCloud (`sonar-maven-plugin`)
* **Continuous Delivery / Deployment:** GitHub Packages & GitHub Actions

## 5. Panduan Menjalankan Proyek Secara Lokal

Untuk menjalankan aplikasi BukaBuku ini secara lokal, pastikan **Java (minimal JDK 23)** dan **Maven** sudah terinstal di komputer. 

1. *Clone* repositori ini ke komputer lokal:
   ```bash
   git clone https://github.com/EdselSpth/BukaBuku-Tubes-MKEPL.git
   cd BukaBuku-Tubes-MKEPL

2. Lakukan build dan pastikan dependensi terunduh menggunakan Maven:
   ```bash
   mvn clean install

3. Jalankan aplikasi melalui main class:
   ```bash
   mvn exec:java -Dexec.mainClass="com.mycompany.sistem.Main"

4. Aplikasi CLI BukaBuku akan berjalan. Silakan login menggunakan kredensial Admin atau User yang disediakan

## Account Login
1. Admin
Username : Admin123
Password : Admin123
2. User
Username : User123
Password : User123
