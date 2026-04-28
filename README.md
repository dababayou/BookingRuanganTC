# TCRoom - Booking Ruangan TC

Aplikasi Android modern berbasis **Jetpack Compose** untuk mempermudah proses pemesanan ruangan di Departemen Teknik (TC). Aplikasi ini dirancang untuk membantu mahasiswa maupun dosen dalam mengecek ketersediaan fasilitas dan melakukan reservasi secara digital.

## 📄 Deskripsi & Fitur
Aplikasi ini menyediakan antarmuka yang intuitif untuk mengelola peminjaman fasilitas akademik. 

### Fitur Utama:
*   **Daftar Ruangan Real-time:** Menampilkan informasi lengkap mengenai kapasitas, lokasi, dan fasilitas (Proyektor, PC, Audio) dari berbagai ruangan (Ruang Kelas, Lab Pemrograman, dan Aula).
*   **Formulir Pemesanan Digital:** Input data peminjam (Nama & NRP/NIP) serta keperluan acara.
*   **Penjadwalan Presisi:** Integrasi *Date Picker* dan *Time Wheel Picker* untuk menentukan waktu pemakaian yang akurat.
*   **Konfirmasi Reservasi:** Ringkasan detail pemesanan setelah formulir berhasil dikirim.
*   **UI Modern:** Menggunakan Material Design 3 dengan tema warna biru yang profesional dan bersih.

## 🖼️ Infografis Aplikasi
> ![Thumbnail Aplikasi](https://via.placeholder.com/800x400?text=Placeholder+Infografis+TCRoom)
> *Keterangan: Ganti link di atas dengan path gambar infografis atau screenshot aplikasi Anda di folder assets.*

## 🚀 Cara Mengerjakan & Menjalankan

### Prasyarat
*   **Android Studio** (versi Ladybug atau yang terbaru direkomendasikan).
*   **JDK 17** atau yang lebih baru.
*   Perangkat Android (Physical Device) atau Emulator dengan **API Level 24+**.

### Langkah-langkah
1.  **Clone Repositori:**
    ```bash
    git clone https://github.com/username/BookingRuanganTC.git
    ```
2.  **Buka di Android Studio:**
    Pilih menu `File > Open` dan arahkan ke folder proyek ini.
3.  **Sync Gradle:**
    Tunggu hingga proses *Gradle Sync* selesai. Pastikan koneksi internet stabil untuk mengunduh dependensi.
4.  **Jalankan:**
    Klik tombol **Run** (ikon play hijau) di toolbar atas Android Studio.

## 🛠️ Penjelasan Kode
Struktur kode aplikasi ini berfokus pada kesederhanaan dan keterbacaan menggunakan Jetpack Compose dalam satu file utama (`MainActivity.kt`):

1.  **Data Model (`Room`):**
    Class data yang menyimpan atribut ruangan seperti `name`, `capacity`, `location`, dan `facilities`.
2.  **State Management:**
    Menggunakan `remember` dan `mutableStateOf` untuk mengatur navigasi antar layar (Layar Daftar -> Layar Form -> Layar Konfirmasi) tanpa perlu fragment manual.
3.  **Komponen Utama (Composables):**
    *   `RoomListScreen`: Menggunakan `LazyColumn` untuk merender daftar ruangan secara efisien.
    *   `BookingFormScreen`: Mengelola input pengguna dan validasi form sederhana (`isValid`).
    *   `TimeWheelInput`: Implementasi kustom menggunakan `AndroidView` untuk memanggil `NumberPicker` klasik di dalam lingkungan Compose.
    *   `ConfirmationScreen`: Layar akhir yang menampilkan status keberhasilan pemesanan.
4.  **UI Styling:**
    Memanfaatkan `Card`, `Brush` untuk gradient, dan `Shape` untuk memberikan tampilan modern pada setiap elemen kartu ruangan.
