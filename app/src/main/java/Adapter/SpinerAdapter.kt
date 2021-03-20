package Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import com.ilhomjon.homework423.R
import kotlinx.android.synthetic.main.child_group.view.*
import kotlinx.android.synthetic.main.item_group.view.*

class ExpandetAdapter(var titleList: List<String>, var map: HashMap<String, ArrayList<String>>) :
        BaseExpandableListAdapter() {
    override fun getGroup(groupPosition: Int): String = titleList[groupPosition]

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean =true

    override fun hasStableIds(): Boolean = true

    override fun getGroupView(
            groupPosition: Int,
            isExpanded: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {
        var groupItemView:View
        if (convertView == null){
            groupItemView = LayoutInflater.from(parent?.context).inflate(R.layout.item_group, parent, false)
        }else{
            groupItemView = convertView
        }

        groupItemView.txt_name.text = titleList[groupPosition]
        return groupItemView
    }

    override fun getChildrenCount(groupPosition: Int): Int = map[titleList[groupPosition]]!!.size

    override fun getChild(groupPosition: Int, childPosition: Int): Any {
        return map[titleList[groupPosition]]!!.get(childPosition)
    }

    override fun getGroupId(groupPosition: Int): Long = groupPosition.toLong()

    override fun getChildView(
            groupPosition: Int,
            childPosition: Int,
            isLastChild: Boolean,
            convertView: View?,
            parent: ViewGroup?
    ): View {
        var childItemView:View
        if (convertView == null){
            childItemView = LayoutInflater.from(parent?.context).inflate(R.layout.child_group, parent, false)
        }else{
            childItemView = convertView
        }

        val list = map[titleList[groupPosition]]
        val childItem = list?.get(childPosition)
        childItemView.txt_child.text = childItem

        return childItemView
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long = childPosition.toLong()

    override fun getGroupCount(): Int = titleList.size
}
