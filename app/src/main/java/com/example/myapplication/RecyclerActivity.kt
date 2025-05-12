package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityPageBinding
import com.example.myapplication.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    private lateinit var makeupRecyclerView: RecyclerView
    private lateinit var makeupAdapter: MyAdapter
    private lateinit var listMakeup : ArrayList<ItemData>

    private lateinit var binding: ActivityRecyclerBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        makeupRecyclerView = findViewById(R.id.makeupRV)
        listMakeup = ArrayList()

        listMakeup.add(ItemData(R.drawable.moist, "Skin Preparation", "Moisturizer",
            "Skin preparation sebelum makeup itu penting banget, dan moisturizer adalah salah satu langkah kunci biar hasil makeup lebih halus, tahan lama, dan nggak cracky. \n" +
                    "Manfaat melembapkan kulit Supaya kulit nggak kering dan makeup bisa nge-blend lebih baik, menyeimbangkan minyak untuk kulit berminyak, moisturizer membantu mengontrol sebum, menciptakan base yang halus karena complexion lebih mudah diratakan, dan meningkatkan daya tahan makeup. \n" +
                    "Untuk kulit kering, pilih cream-based moisturizer dengan kandungan seperti hyaluronic acid, ceramide, glycerin, dan shea butter. \n" +
                    "Untuk kulit berminyak / kombinasi, pilih gel-based atau oil-free moisturizer. Cari yang non-comedogenic. Untu kulit sensitif, pilih moisturizer yang bebas parfum dan alkohol, dengan kandungan calming seperti centella asiatica atau panthenol."))

        listMakeup.add(ItemData(R.drawable.ss,  "Skin Preparation", "Sunscreen",
            "Sunscreen adalah langkah penting dalam skin preparation sebelum makeup karena berfungsi melindungi kulit dari paparan sinar UV yang dapat menyebabkan penuaan dini, hiperpigmentasi, dan kerusakan kulit. \n" +
                    "Menggunakan sunscreen sebelum makeup membantu menjaga kesehatan kulit dalam jangka panjang, sekaligus menciptakan dasar yang lebih halus dan merata. \n" +
                    "Pilih sunscreen dengan broad spectrum SPF minimal 30, dan pastikan formulanya cocok dengan jenis kulit baik itu gel untuk kulit berminyak atau krim untuk kulit kering agar tidak mengganggu aplikasi makeup selanjutnya."))

        listMakeup.add(ItemData(R.drawable.com, "Complexion", "Foundation, Cushion, Concealer, Skintint",
            "Complexion makeup mencakup berbagai produk yang berfungsi untuk meratakan warna kulit, menyamarkan ketidaksempurnaan, dan menciptakan tampilan wajah yang segar dan flawless. Produk-produk utamanya antara lain:\n" +
                    "Foundation: Memberikan coverage yang merata pada seluruh wajah, tersedia dalam berbagai formula dan tingkat ketebalan, cocok untuk tampilan makeup yang lebih tahan lama.\n" +
                    "Skin tint: Versi ringan dari foundation, memberikan hasil natural dengan coverage tipis, ideal untuk tampilan sehari-hari yang minimalis.\n" +
                    "Concealer: Digunakan secara spesifik untuk menutupi area tertentu seperti bekas jerawat, kemerahan, atau lingkaran hitam di bawah mata.\n" +
                    "Cushion: Foundation dalam bentuk compact dengan aplikator sponge, praktis digunakan dan biasanya memiliki hasil akhir dewy yang segar.\n" +
                    "Dengan pemilihan dan pengaplikasian yang tepat, complexion makeup mampu menciptakan dasar makeup yang sempurna sesuai kebutuhan dan preferensi tampilan."))

        listMakeup.add(ItemData(R.drawable.blush,  "Cheek",  "Cream Blush",
            "Blush on adalah produk makeup yang digunakan untuk memberikan rona segar dan sehat pada pipi, sekaligus menambah dimensi pada wajah. Aplikasinya membantu menciptakan tampilan yang lebih hidup dan merona alami. \n" +
                    "Blush on hadir dalam berbagai bentuk, seperti powder, cream, dan liquid, yang bisa dipilih sesuai dengan jenis kulit dan hasil akhir yang diinginkan—dari yang matte hingga dewy. Warna blush on pun beragam, mulai dari pink, peach, hingga coral, dan dapat disesuaikan dengan tone kulit untuk hasil yang lebih menyatu dan natural."))

        listMakeup.add(ItemData(R.drawable.loose,  "Powder", "Loose Powder",
            "Powder makeup adalah produk yang digunakan untuk mengunci foundation dan concealer, serta mengontrol minyak berlebih agar tampilan wajah tetap matte dan tahan lama. Terdiri dari dua jenis utama: loose powder (bedak tabur) yang ringan dan cocok untuk hasil akhir natural, serta pressed powder (bedak padat) yang praktis untuk touch-up saat bepergian. \n" +
                    "Powder juga membantu menyamarkan pori-pori dan garis halus, menjadikan kulit tampak lebih halus dan lembut. Penggunaan powder yang tepat merupakan langkah penting dalam menyempurnakan complexion makeup dan menjaga riasan tetap on point sepanjang hari."))

        listMakeup.add(ItemData(R.drawable.eyeshadow,  "Eye Makeup", "Eyeshadow",
            "Eyeshadow adalah produk makeup yang digunakan untuk memberikan warna, dimensi, dan ekspresi pada kelopak mata. Tersedia dalam berbagai bentuk seperti powder, cream, dan liquid, eyeshadow memungkinkan pengguna untuk menciptakan berbagai tampilan dari natural hingga dramatis. \n" +
                    "Warna-warna netral cocok untuk keseharian, sementara warna bold atau shimmer sering digunakan untuk acara khusus. \n" +
                    "Teknik aplikasi seperti blending dan layering membantu menciptakan gradasi warna yang halus dan mempertegas bentuk mata. Eyeshadow menjadi elemen penting dalam mempercantik riasan mata dan menambah kesan artistik pada keseluruhan tampilan wajah."))

        listMakeup.add(ItemData(R.drawable.eyeliner,  "Eye Makeup", "Eyeliner",
            "Eyeliner adalah produk makeup yang digunakan untuk mempertegas garis mata, menciptakan ilusi mata yang lebih tajam, besar, atau dramatis. Eyeliner tersedia dalam berbagai bentuk seperti pensil, gel, liquid, dan felt-tip, masing-masing memberikan hasil akhir yang berbeda—dari tampilan natural hingga bold. \n" +
                    "Warna hitam klasik sering digunakan untuk kesan tajam, sementara warna cokelat atau warna-warni bisa memberikan tampilan yang lebih lembut atau kreatif. Pengaplikasian eyeliner dapat disesuaikan dengan gaya, seperti winged liner untuk tampilan cat-eye atau tightlining untuk efek bulu mata yang lebih tebal secara alami."))

        listMakeup.add(ItemData(R.drawable.highlighter, "Highlighter",  "Highlighter",
            "Highlighter adalah produk makeup yang digunakan untuk memberikan efek kilau dan dimensi pada wajah dengan menonjolkan area tertentu seperti tulang pipi, batang hidung, tulang alis, dan cupid’s bow. \n" +
                    "Dengan sentuhan cahaya yang halus atau shimmering, highlighter menciptakan tampilan wajah yang tampak lebih segar, glowing, dan sehat. Tersedia dalam bentuk powder, liquid, maupun cream, penggunaannya bisa disesuaikan dengan jenis kulit dan hasil akhir yang diinginkan—baik dewy alami maupun glamor yang mencolok. Highlighter menjadi sentuhan akhir yang mempercantik keseluruhan makeup look."))

        listMakeup.add(ItemData(R.drawable.lipbalm, "Lippies",  "Lipbalm",
            "Lip balm adalah produk perawatan bibir yang berfungsi untuk melembapkan dan menutrisi bibir, mencegah bibir kering atau pecah-pecah. Sebagai bagian dari makeup, lip balm sering digunakan sebagai langkah awal sebelum mengaplikasikan lipstik untuk menciptakan dasar yang halus dan menjaga kelembapan bibir sepanjang hari. \n" +
                    "Beberapa lip balm juga mengandung pewarna ringan, memberikan rona alami pada bibir tanpa mengorbankan kelembapan. Lip balm sangat penting untuk memastikan bibir tetap lembut dan nyaman, serta membantu menghasilkan aplikasi lipstik yang lebih rata dan tahan lama."))

        listMakeup.add(ItemData(R.drawable.lippies,  "Lippies", "Lipcream, Liptint, Lipgloss",
            "Produk bibir makeup mencakup berbagai pilihan yang dapat memberikan tampilan dan tekstur yang berbeda pada bibir.\n" +
                    "Lip cream: Memberikan warna yang kaya dan tahan lama dengan tekstur creamy yang lembut. Lip cream sering kali memberikan hasil akhir matte atau semi-matte, cocok untuk tampilan bold dan tahan lama tanpa membuat bibir kering.\n" +
                    "Lip gloss: Memberikan kilau dan kelembapan pada bibir dengan efek glossy. Lip gloss cenderung memiliki finish yang dewy dan ringan, ideal untuk tampilan segar dan natural, serta memberikan ilusi bibir lebih penuh.\n" +
                    "Lip tint: Memiliki formula cair yang ringan dengan hasil akhir yang lebih natural dan tahan lama. Lip tint memberikan warna yang meresap ke bibir, menghasilkan tampilan yang lebih tipis dan natural, serta cocok untuk tampilan sehari-hari dengan perawatan minimal.\n" +
                    "Ketiga produk ini menawarkan variasi tampilan, dari yang lebih intens hingga yang lebih natural, sesuai dengan preferensi dan kesempatan."))

        listMakeup.add(ItemData(R.drawable.setspray, "Setting Spray", "Setting Spray",
            "Setting spray adalah produk makeup yang digunakan untuk mengunci riasan agar tetap tahan lama sepanjang hari. Dengan formula yang ringan dan sering kali mengandung bahan pelembap atau pengontrol minyak, setting spray membantu menjaga agar makeup tetap segar, tidak luntur, atau bergeser. \n" +
                    "Penggunaannya setelah selesai makeup memberikan hasil akhir yang lebih halus, memperbaiki tampilan kulit, dan mencegah cakey. \n" +
                    "Beberapa setting spray juga memberikan efek dewy atau matte, tergantung pada jenis kulit dan tampilan yang diinginkan. Setting spray menjadi langkah terakhir yang penting untuk memastikan makeup tetap on point dalam berbagai kondisi sepanjang hari."))


        makeupRecyclerView.layoutManager = LinearLayoutManager(this)
        makeupRecyclerView.setHasFixedSize(true)
        makeupAdapter = MyAdapter(listMakeup)
        makeupRecyclerView.adapter = makeupAdapter

        makeupAdapter.onItemClick = { selectedItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("item", selectedItem)
            startActivity(intent)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item -> {
                startActivity(Intent(this, ProfileActivity::class.java))
                true
            }
            R.id.item2 -> {
                startActivity(Intent(this, SettingsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}