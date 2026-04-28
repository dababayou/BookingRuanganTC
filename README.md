# TCRoom - Booking Ruangan TC

Aplikasi Android modern berbasis **Jetpack Compose** untuk mempermudah proses pemesanan ruangan di Departemen Teknik Informatika (TC). Aplikasi ini dirancang untuk membantu mahasiswa maupun dosen dalam mengecek ketersediaan fasilitas dan melakukan reservasi secara digital.

### Anggota Kelompok:
- Bayu Nismara Nagatama  - 5025231152
- Muhammad Rafi Budiman  - 5025231297

## 📲 Download & Instalasi
| Aplication | Link |
|---|---|
| **TCRoom** | [📥 Download APK](https://github.com/Gembut/BookingRuanganTC/raw/main/TCRoom.apk) |

> **Catatan:** Untuk menginstal APK, pastikan Anda telah mengizinkan "Install from Unknown Sources" di pengaturan HP Anda.

## 📄 Deskripsi & Fitur
Aplikasi ini menyediakan antarmuka yang intuitif untuk mengelola peminjaman fasilitas akademik. 

### Fitur Utama:
*   **Daftar Ruangan Real-time:** Menampilkan informasi lengkap mengenai kapasitas, lokasi, dan fasilitas (Proyektor, PC, Audio) dari berbagai ruangan (Ruang Kelas, Lab Pemrograman, dan Aula).
*   **Formulir Pemesanan Digital:** Input data peminjam (Nama & NRP/NIP) serta keperluan acara.
*   **Penjadwalan Presisi:** Integrasi *Date Picker* dan *Time Wheel Picker* untuk menentukan waktu pemakaian yang akurat.
*   **Konfirmasi Reservasi:** Ringkasan detail pemesanan setelah formulir berhasil dikirim.
*   **UI Modern & Dark Mode:** Menggunakan Material Design 3 dengan dukungan tema gelap otomatis untuk kenyamanan mata.

## 🖼️ Infografis Aplikasi
| | |
|---|---|
| <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/92ddc0f9-6396-4410-bc37-3daa8a13c4f4" /> | <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/06e6c3a1-1721-4ac7-9ac1-f5c6b2b7d3aa" /> | 
| <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/25d304e8-16dc-44c0-9faa-2898585cc796" /> | <img width="300" height="650" alt="image" src="https://github.com/user-attachments/assets/91088220-10f9-44f8-aa52-79cb536cd121" /> |
| <img width="300" height="650" alt="Screenshot 2026-04-28 170625" src="https://github.com/user-attachments/assets/e1cbcabb-5ff2-4b4a-b614-c7b51e9c46c6" /> | <img width="300" height="650" alt="Screenshot 2026-04-28 170720" src="https://github.com/user-attachments/assets/bdde381f-20f4-4e67-a64a-4fd8becc465b" /> | 
| <img width="300" height="650" alt="Screenshot 2026-04-28 170653" src="https://github.com/user-attachments/assets/c4a2affe-32d7-43d0-8f9c-9137b252514d" /> | <img width="300" height="650" alt="Screenshot 2026-04-28 170814" src="https://github.com/user-attachments/assets/fef86105-8c08-4443-afe8-c8f32a0af160" /> |

## PPT - Deskripsi, Desain, Cara Mengerjakan
File presentasi dapat anda akses di [Sini](https://github.com/Gembut/BookingRuanganTC/blob/main/Presentasi%20ETS%20PPB_5025231152_5025231297.pdf)

## 🚀 Cara Mengerjakan & Menjalankan

### Prasyarat
*   **Android Studio** (versi Ladybug atau yang terbaru).
*   **JDK 17**.
*   Perangkat Android (API Level 24+).

Anda dapat langsung mendownload aplikasi melalui [link ini](https://github.com/Gembut/BookingRuanganTC/raw/main/TCRoom.apk) atau clone repository ini dengan cara:
### Langkah-langkah
1.  **Clone Repositori:** `git clone https://github.com/Gembut/BookingRuanganTC.git`
2.  **Buka di Android Studio.**
3.  **Sync Gradle** dan jalankan aplikasi.

## 🛠️ Penjelasan Kode
Struktur kode aplikasi ini berfokus pada kesederhanaan menggunakan Jetpack Compose dalam `MainActivity.kt`:
1.  **Data Model (`Room`):** Atribut ruangan lengkap.
2.  **State Management:** Navigasi antar layar reaktif.
3.  **Animasi:** Transisi `AnimatedContent` untuk UI yang *smooth*.
4.  **Validasi:** Blokir tanggal masa lalu dan validasi input form.
5.  **Dark Mode:** Dukungan tema gelap otomatis.
