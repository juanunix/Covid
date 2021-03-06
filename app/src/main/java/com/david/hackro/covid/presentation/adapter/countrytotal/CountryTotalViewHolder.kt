package com.david.hackro.covid.presentation.adapter.countrytotal

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.david.hackro.covid.presentation.adapter.wordltotal.WorldTotalViewHolder
import com.david.hackro.covid.presentation.model.CountryTotalItem
import com.david.hackro.covid.presentation.model.getBackgroundByStatus
import com.david.hackro.covid.presentation.model.getColorByStatus
import com.david.hackro.covid.presentation.model.getDescriptionByStatus
import com.david.hackro.covid.presentation.model.getIconByStatus
import kotlinx.android.synthetic.main.item_country_total.view.totalLabel
import kotlinx.android.synthetic.main.item_country_total.view.totalNumber
import kotlinx.android.synthetic.main.item_country_total.view.total_icon
import java.text.NumberFormat
import java.util.Locale

class CountryTotalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun renderView(worldTotal: CountryTotalItem) {
        itemView.run {
            totalNumber.text = getTotal(worldTotal.progress)
            totalLabel.text = resources.getString(worldTotal.status.getDescriptionByStatus())
            totalNumber.setTextColor(resources.getColor(worldTotal.status.getColorByStatus()))
            total_icon.background = resources.getDrawable(worldTotal.status.getIconByStatus())
            background = resources.getDrawable(worldTotal.status.getBackgroundByStatus())
        }
    }

    private fun getTotal(progress: Int) = if (progress > 0) NumberFormat.getNumberInstance(Locale.US).format(progress)
    else TOTAL_EMPTY_DEFAULT

    private companion object {
        const val TOTAL_EMPTY_DEFAULT = "- -"
    }
}

