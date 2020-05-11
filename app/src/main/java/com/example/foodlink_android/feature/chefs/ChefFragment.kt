package com.example.foodlink_android.feature.chefs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodlink_android.R
import com.example.foodlink_android.common.adapters.ChefAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog

class ChefFragment : Fragment() {

    private lateinit var recyclerChef: RecyclerView
    private lateinit var filter: TextView
    private lateinit var adapterChef: ChefAdapter

    companion object {
        fun newInstance(data: Bundle? = null): ChefFragment {
            val fragment = ChefFragment()
            fragment.arguments = data
            return fragment
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.chefs_fragment, container, false)
    }

    private fun bind(view: View) = with(view) {
        recyclerChef = findViewById(R.id.recycler_chefs)
        filter = findViewById(R.id.filter)
        filter.setOnClickListener {
            showDialogFilter()
        }
        adapterChef = ChefAdapter(generateTestChefs())
        recyclerChef.apply {
            layoutManager = LinearLayoutManager(
                activity!!,
                LinearLayoutManager.VERTICAL,
                false
            )
            adapter = adapterChef
        }
    }

    private fun showDialogFilter(){
        val view = layoutInflater.inflate(R.layout.dialog_content, null)
        val dialog = BottomSheetDialog(activity!!)
        dialog.setContentView(view)
        dialog.show()

    }

    private fun generateTestChefs(): ArrayList<ChefData> {
        return arrayListOf(
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            ),
            ChefData(
                null,
                "Taiyr Khassenov",
                "I'm so sad and feel lonely",
                6.0f,
                121
            )
        )
    }
}