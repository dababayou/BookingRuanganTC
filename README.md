# TCRoom - Booking Ruangan TC

Aplikasi Android modern berbasis **Jetpack Compose** untuk mempermudah proses pemesanan ruangan di Departemen Teknik Informatika (TC). Aplikasi ini dirancang untuk membantu mahasiswa maupun dosen dalam mengecek ketersediaan fasilitas dan melakukan reservasi secara digital.

## 📄 Deskripsi & Fitur
Aplikasi ini menyediakan antarmuka yang intuitif untuk mengelola peminjaman fasilitas akademik. 

### Fitur Utama:
*   **Daftar Ruangan Real-time:** Menampilkan informasi lengkap mengenai kapasitas, lokasi, dan fasilitas (Proyektor, PC, Audio) dari berbagai ruangan (Ruang Kelas, Lab Pemrograman, dan Aula).
*   **Formulir Pemesanan Digital:** Input data peminjam (Nama & NRP/NIP) serta keperluan acara.
*   **Penjadwalan Presisi:** Integrasi *Date Picker* dan *Time Wheel Picker* untuk menentukan waktu pemakaian yang akurat.
*   **Konfirmasi Reservasi:** Ringkasan detail pemesanan setelah formulir berhasil dikirim.
*   **UI Modern:** Menggunakan Material Design 3 dengan tema warna biru yang profesional dan bersih.

## 🖼️ Infografis Aplikasi
| | |
|---|---|
| <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/92ddc0f9-6396-4410-bc37-3daa8a13c4f4" /> | <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/06e6c3a1-1721-4ac7-9ac1-f5c6b2b7d3aa" /> | 
| <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/25d304e8-16dc-44c0-9faa-2898585cc796" /> | <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/91088220-10f9-44f8-aa52-79cb536cd121" /> |
| <img width="300" height="650" alt="Screenshot 2026-04-28 170625" src="https://github.com/user-attachments/assets/e1cbcabb-5ff2-4b4a-b614-c7b51e9c46c6" /> | <img width="300" height="650" alt="Screenshot 2026-04-28 170720" src="https://github.com/user-attachments/assets/bdde381f-20f4-4e67-a64a-4fd8becc465b" /> | 
| <img width="300" height="650" alt="Screenshot 2026-04-28 170653" src="https://github.com/user-attachments/assets/c4a2affe-32d7-43d0-8f9c-9137b252514d" /> | <img width="300" height="650" alt="Screenshot 2026-04-28 170814" src="https://github.com/user-attachments/assets/fef86105-8c08-4443-afe8-c8f32a0af160" /> |

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
