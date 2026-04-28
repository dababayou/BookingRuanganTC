package com.example.bookingruangantc

import android.os.Bundle
import android.widget.NumberPicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.bookingruangantc.ui.theme.BookingRuanganTCTheme
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

data class Room(
    val id: Int,
    val name: String,
    val capacity: Int,
    val location: String,
    val description: String,
    val facilities: String
)

val dummyRooms = listOf(
    Room(1, "Ruang 101", 30, "Lantai 1 sebelah utara", "Ruang kelas.", "Proyektor + komputer, kursi + meja"),
    Room(2, "Ruang 102", 30, "Lantai 1 sebelah utara", "Ruang kelas.", "Proyektor + komputer, kursi + meja"),
    Room(3, "Ruang 103", 30, "Lantai 1 sebelah utara", "Ruang kelas.", "Proyektor + komputer, kursi + meja"),
    Room(4, "Ruang 104", 30, "Lantai 1 sebelah utara", "Ruang kelas.", "Proyektor + komputer, kursi + meja"),
    Room(5, "Ruang 105", 100, "Lantai 1 sebelah utara", "Ruang kelas besar/seminar.", "Proyektor + komputer, kursi+meja, speaker, mic"),
    Room(6, "Ruang 106", 30, "Lantai 1 sebelah timur", "Ruang kelas.", "Proyektor + komputer, kursi + meja"),
    Room(7, "Ruang 107", 100, "Lantai 1 sebelah timur", "Ruang kelas besar.", "2 smart tv + komputer, kursi dan meja, speaker, mic"),
    Room(8, "Ruang 108", 30, "Lantai 1 sebelah timur", "Ruang kelas.", "Proyektor + komputer, kursi dan meja"),
    Room(9, "Lab Pemrograman (LP) 1", 100, "Lantai 3 sebelah utara", "Laboratorium komputer.", "Proyektor + komputer di dipan, komputer setiap kursi, kursi dan meja, speaker+mic"),
    Room(10, "Lab Pemrograman (LP) 2", 100, "Lantai 3 sebelah selatan", "Laboratorium komputer.", "Proyektor+komputer di dipan, komputer setiap kursi, kursi dan meja, speaker+mic"),
    Room(11, "Aula Handayani", 150, "Lantai 2 sebelah timur", "Aula utama.", "Layar utama dan TV tambahan, kursi dan meja, speaker, mic")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BookingRuanganTCTheme {
                var selectedRoom by remember { mutableStateOf<Room?>(null) }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                    ) {
                        AnimatedContent(
                            targetState = selectedRoom,
                            transitionSpec = {
                                fadeIn() togetherWith fadeOut()
                            },
                            label = "screen_transition"
                        ) { targetRoom ->
                            if (targetRoom == null) {
                                RoomListScreen(
                                    rooms = dummyRooms,
                                    onRoomClick = { room ->
                                        selectedRoom = room
                                    }
                                )
                            } else {
                                BookingFormScreen(
                                    room = targetRoom,
                                    onBack = {
                                        selectedRoom = null
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun RoomListScreen(
    rooms: List<Room>,
    onRoomClick: (Room) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        item {
            HeaderSection()
        }

        items(rooms) { room ->
            RoomCard(
                room = room,
                onClick = {
                    onRoomClick(room)
                }
            )
        }
    }
}

@Composable
fun HeaderSection() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary,
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .padding(22.dp)
        ) {
            Column {
                Text(
                    text = "TCRoom - Booking Ruangan TC",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Pilih ruangan yang ingin dipesan untuk kegiatan akademik atau acara departemen.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White.copy(alpha = 0.9f)
                )
            }
        }
    }

    Spacer(modifier = Modifier.height(8.dp))

    Text(
        text = "Daftar Ruangan",
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Composable
fun RoomCard(
    room: Room,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.size(52.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.MeetingRoom,
                            contentDescription = "Room Icon",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = room.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Text(
                        text = room.description,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            InfoRow(
                icon = Icons.Default.Groups,
                text = "Kapasitas: ${room.capacity} orang"
            )

            Spacer(modifier = Modifier.height(6.dp))

            InfoRow(
                icon = Icons.Default.LocationOn,
                text = room.location
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Text(
                    text = "Fasilitas: ${room.facilities}",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = onClick,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Booking Ruangan")
            }
        }
    }
}

@Composable
fun InfoRow(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(18.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingFormScreen(
    room: Room,
    onBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var purpose by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var selectedTime by remember { mutableStateOf("") }
    var isConfirmed by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }

    val isValid = name.isNotBlank()
            && nim.isNotBlank()
            && purpose.isNotBlank()
            && selectedDate.isNotBlank()
            && selectedTime.isNotBlank()

    if (showDatePicker) {
        DatePickerModal(
            onDateSelected = { date ->
                selectedDate = date
                showDatePicker = false
            },
            onDismiss = {
                showDatePicker = false
            }
        )
    }

    if (!isConfirmed) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Kembali",
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    }

                    Text(
                        text = "Form Pemesanan",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }

            item {
                SelectedRoomCard(room = room)
            }

            item {
                Text(
                    text = "Data Peminjam",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            item {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nama Peminjam") },
                    placeholder = { Text("Masukkan nama lengkap") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }

            item {
                OutlinedTextField(
                    value = nim,
                    onValueChange = { nim = it },
                    label = { Text("NRP / NIP") },
                    placeholder = { Text("Contoh: 502523xxxx") },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }

            item {
                OutlinedTextField(
                    value = purpose,
                    onValueChange = { purpose = it },
                    label = { Text("Keperluan") },
                    placeholder = { Text("Contoh: Rapat organisasi / kuliah tamu") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = MaterialTheme.colorScheme.onBackground,
                        unfocusedTextColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }

            item {
                Text(
                    text = "Jadwal Booking",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }

            item {
                OutlinedTextField(
                    value = selectedDate,
                    onValueChange = {},
                    label = { Text("Tanggal") },
                    placeholder = { Text("Pilih tanggal booking") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            showDatePicker = true
                        },
                    enabled = false,
                    shape = RoundedCornerShape(14.dp),
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = "Pilih Tanggal"
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        disabledTextColor = MaterialTheme.colorScheme.onBackground,
                        disabledBorderColor = MaterialTheme.colorScheme.outline,
                        disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        disabledTrailingIconColor = MaterialTheme.colorScheme.primary
                    )
                )
            }

            item {
                TimeWheelInput(
                    selectedTime = selectedTime,
                    onTimeSelected = { time ->
                        selectedTime = time
                    }
                )
            }

            item {
                if (!isValid) {
                    Text(
                        text = "Lengkapi nama, NRP, keperluan, tanggal, dan waktu terlebih dahulu.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onBack,
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Batal")
                    }

                    Button(
                        onClick = {
                            isConfirmed = true
                        },
                        modifier = Modifier.weight(1f),
                        enabled = isValid,
                        shape = RoundedCornerShape(14.dp)
                    ) {
                        Text("Pesan")
                    }
                }
            }
        }
    } else {
        ConfirmationScreen(
            room = room,
            name = name,
            nim = nim,
            purpose = purpose,
            date = selectedDate,
            time = selectedTime,
            onBack = onBack
        )
    }
}

@Composable
fun TimeWheelInput(
    selectedTime: String,
    onTimeSelected: (String) -> Unit
) {
    val hours = (7..18).map { it.toString().padStart(2, '0') }
    val minutes = arrayOf("00", "15", "30", "45")

    var selectedHourIndex by remember { mutableStateOf(0) }
    var selectedMinuteIndex by remember { mutableStateOf(0) }

    LaunchedEffect(Unit) {
        if (selectedTime.isBlank()) {
            onTimeSelected("${hours[0]}:${minutes[0]}")
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Waktu Booking",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(12.dp))

        Surface(
            shape = RoundedCornerShape(14.dp),
            color = MaterialTheme.colorScheme.surface,
            border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AndroidView(
                    modifier = Modifier.weight(1f),
                    factory = { context ->
                        NumberPicker(context).apply {
                            minValue = 0
                            maxValue = hours.size - 1
                            displayedValues = hours.toTypedArray()
                            wrapSelectorWheel = true
                            setOnValueChangedListener { _, _, newVal ->
                                selectedHourIndex = newVal
                                onTimeSelected("${hours[selectedHourIndex]}:${minutes[selectedMinuteIndex]}")
                            }
                        }
                    }
                )

                Text(
                    text = ":",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                AndroidView(
                    modifier = Modifier.weight(1f),
                    factory = { context ->
                        NumberPicker(context).apply {
                            minValue = 0
                            maxValue = minutes.size - 1
                            displayedValues = minutes
                            wrapSelectorWheel = true
                            setOnValueChangedListener { _, _, newVal ->
                                selectedMinuteIndex = newVal
                                onTimeSelected("${hours[selectedHourIndex]}:${minutes[selectedMinuteIndex]}")
                            }
                        }
                    }
                )
            }
        }

        if (selectedTime.isNotBlank()) {
            Spacer(modifier = Modifier.height(12.dp))
            Surface(
                shape = RoundedCornerShape(10.dp),
                color = MaterialTheme.colorScheme.primaryContainer,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Waktu dipilih: $selectedTime",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun SelectedRoomCard(room: Room) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Text(
                text = room.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )

            Spacer(modifier = Modifier.height(8.dp))

            InfoRow(
                icon = Icons.Default.Groups,
                text = "Kapasitas: ${room.capacity} orang"
            )

            Spacer(modifier = Modifier.height(6.dp))

            InfoRow(
                icon = Icons.Default.LocationOn,
                text = room.location
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = room.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (String) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState(
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                calendar.set(Calendar.HOUR_OF_DAY, 0)
                calendar.set(Calendar.MINUTE, 0)
                calendar.set(Calendar.SECOND, 0)
                calendar.set(Calendar.MILLISECOND, 0)
                return utcTimeMillis >= calendar.timeInMillis
            }
        }
    )

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(
                onClick = {
                    val selectedMillis = datePickerState.selectedDateMillis

                    if (selectedMillis != null) {
                        val formatter = SimpleDateFormat(
                            "dd MMMM yyyy",
                            Locale("id", "ID")
                        )

                        val formattedDate = formatter.format(Date(selectedMillis))
                        onDateSelected(formattedDate)
                    }
                }
            ) {
                Text("Pilih")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Batal")
            }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

@Composable
fun ConfirmationScreen(
    room: Room,
    name: String,
    nim: String,
    purpose: String,
    date: String,
    time: String,
    onBack: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Berhasil",
                    tint = Color(0xFF2E7D32),
                    modifier = Modifier.size(72.dp)
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "Booking Berhasil!",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF2E7D32)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Pemesanan ruangan berhasil dibuat.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.height(24.dp))

                BookingDetailItem("Ruangan", room.name)
                BookingDetailItem("Nama", name)
                BookingDetailItem("NRP / NIP", nim)
                BookingDetailItem("Keperluan", purpose)
                BookingDetailItem("Tanggal", date)
                BookingDetailItem("Waktu", time)
                BookingDetailItem("Lokasi", room.location)

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text("Kembali ke Daftar Ruangan")
                }
            }
        }
    }
}

@Composable
fun BookingDetailItem(
    label: String,
    value: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}