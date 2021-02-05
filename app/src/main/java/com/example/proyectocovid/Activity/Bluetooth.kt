package com.example.proyectocovid.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.proyectocovid.R
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_bluetooth.*

class Bluetooth : AppCompatActivity() {
    private val REQUEST_CODE_ENABLE_BLUETOOTH: Int = 1
    private val REQUEST_CODE_DISCOVERABLE_BLUETOOTH: Int = 2

    lateinit var blueAdapter: BluetoothAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bluetooth)

        blueAdapter = BluetoothAdapter.getDefaultAdapter()

        if (blueAdapter.isEnabled){
            ImagenStatus.setImageResource(R.drawable.ic_bluetooth_on)
        }
        if (!blueAdapter.isEnabled){
            ImagenStatus.setImageResource(R.drawable.ic_bluetooth_off)
        }
        if (blueAdapter == null) {
            status.setText("Bluetooth no está disponible!!")
        } else {
            status.setText("Bluetooth está disponible!!")
        }
        btnOn.setOnClickListener {
            if (blueAdapter.isEnabled) {
                //Si ya está activado
                Toast.makeText(this, "Bluetooth esta encendido", Toast.LENGTH_LONG).show()
            } else {
                //Encender Bluetooth
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(intent, REQUEST_CODE_ENABLE_BLUETOOTH)
            }
        }
        //Boton apagar bluetooth
        btnOff.setOnClickListener {
            if (!blueAdapter.isEnabled) {
                //Si ya está desactivado
                Toast.makeText(this, "Bluetooth desactivado", Toast.LENGTH_LONG)
                    .show()
            } else {
                //Encender Bluetooth
                blueAdapter.disable()
                ImagenStatus.setImageResource(R.drawable.ic_bluetooth_off)
                Toast.makeText(this, "Desactivado Bluetooth", Toast.LENGTH_LONG).show()

            }
        }
        //Boton ocultar bluetooth
        btnOcultar.setOnClickListener {
            if (!blueAdapter.isDiscovering) {
                Toast.makeText(this, "Dispositivo visible", Toast.LENGTH_LONG).show()
                val intent = Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE)
                startActivityForResult(intent, REQUEST_CODE_DISCOVERABLE_BLUETOOTH)

            }
        }
        //Boton dispositivos emparejados
        btnEmparejar.setOnClickListener {
            txtDevices.setText("")
            if (blueAdapter.isEnabled) {
                //lista de sipositivos
                val devices = blueAdapter.bondedDevices
                for (device in devices) {
                    val name = device.name
                    val dirección = device.address

                    txtDevices.append(" \n Dispositivo: ${name} , ${dirección} \n---------------\n")
                }
            } else {
                Toast.makeText(this, "Activar bluetooth", Toast.LENGTH_LONG).show()
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE_ENABLE_BLUETOOTH ->
                if (resultCode == Activity.RESULT_OK) {
                    Toast.makeText(this, "Se ha activado el Bluetooth", Toast.LENGTH_LONG).show()
                    ImagenStatus.setImageResource(R.drawable.ic_bluetooth_on)

                } else {
                    //Si el usuario deniaga la confirmación del cuadro de dialogo
                    Toast.makeText(this, "No se puede activar bluetooth", Toast.LENGTH_LONG).show()
                    ImagenStatus.setImageResource(R.drawable.ic_bluetooth_off)
                }


        }
        if (blueAdapter.isEnabled) {
            ImagenStatus.setImageResource(R.drawable.ic_bluetooth_on)
        }
        if (!blueAdapter.isEnabled) {
            ImagenStatus.setImageResource(R.drawable.ic_bluetooth_off)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun regresarMenu(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }
}