package com.example.pelle.projectdva232

import android.annotation.SuppressLint
import android.content.Context
import android.preference.PreferenceManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class AlarmListAdapter(private var model: List<AlarmModel>) : RecyclerView.Adapter<AlarmListAdapter.ViewHolder>() {

    private var dark_mode = true
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val itemView = inflater.inflate(R.layout.alarm_layout, parent, false)

        dark_mode = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("DARK_MODE", true)
        this.context = context

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return model.size
    }

    @SuppressLint("SimpleDateFormat")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val alarmModel = model[position]

        var format = SimpleDateFormat("HH:mm")
        val interval = format.format(alarmModel.from) + " - " + format.format(alarmModel.to)
        viewHolder.timeInterval.text = interval

        var listDays = ""
        alarmModel.days?.forEach {
            listDays += "$it "
        }
        format = SimpleDateFormat("dd MMMMM")
        val date = Date()
        date.hours = date.hours + 1

        if (listDays.isEmpty())
            viewHolder.daysActive.text = "Tomorrow " + format.format(date)
        else
            viewHolder.daysActive.text = listDays

        viewHolder.switch.isActivated = alarmModel.isIsActive

        viewHolder.listView.text = alarmModel.list

        if (dark_mode)
            viewHolder.divider.setBackgroundColor(ContextCompat.getColor(context, R.color.dividerColorDark))
        else
            viewHolder.divider.setBackgroundColor(ContextCompat.getColor(context, R.color.dividerColorLight))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var daysActive = itemView.findViewById<TextView>(R.id.daysArrayTextView)
        var switch = itemView.findViewById<Switch>(R.id.alarmActiveSwitch)
        var listView = itemView.findViewById<TextView>(R.id.listTextView)
        var timeInterval = itemView.findViewById<TextView>(R.id.timeInterval)
        var divider = itemView.findViewById<View>(R.id.divider)
    }
}