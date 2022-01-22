package com.example.my6lab.fragments.relation

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.my6lab.R
import com.example.my6lab.data.Node
import com.example.my6lab.fragments.dialog.AddRelationFragment
import com.example.my6lab.fragments.dialog.DeleteRelationFragment
import kotlinx.android.synthetic.main.relation_row.view.*
import kotlinx.android.synthetic.main.relation_row.view.id_value

class RelationAdapter(myElement: Node, statusBool: Boolean, frag: FragmentManager): RecyclerView.Adapter<RelationAdapter.MyViewHolder>() {

    private var nodeList = mutableListOf<Node>()
    private var firstNode = myElement
    private var firstEl = myElement.value
    //child or parent status
    private var status = statusBool
    private var fragmentM = frag


    fun checkRelationNode(nodeValue: Node, nodeNodes: Node, isContaining:Boolean): Boolean {
        return if (isContaining)
            nodeValue.value in nodeNodes.nodes.map { it.value }
        else
            nodeValue.value !in nodeNodes.nodes.map { it.value }
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "test #${position + 1}", Toast.LENGTH_SHORT).show()

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.relation_row, parent, false)
        return MyViewHolder(v)

    }

    override fun getItemCount(): Int {
        return nodeList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = nodeList[position]
        holder.itemView.id_value.text = firstEl.toString()
        holder.itemView.textView2.text = currentItem.value.toString()
        holder.itemView.textView.text = status.toString()


//        holder.itemView.setOnClickListener{
//            Toast.makeText(holder.itemView.context, "pos #${position + 1}", Toast.LENGTH_SHORT).show()
//            holder.itemView.setBackgroundColor(0xFF0FFF0F.toInt())
//        }

        if ((checkRelationNode(firstNode, currentItem, false) && status) || (checkRelationNode(currentItem, firstNode, false) && !status)){

//            val textView = TextView(context)

            //If connection exists make it green and add listener
            if ((checkRelationNode(currentItem, firstNode, true) && status) || (checkRelationNode(firstNode, currentItem, true) && !status)){

                holder.itemView.setBackgroundColor(Color.GREEN)

                holder.itemView.setOnClickListener{
                    var dialogDel = DeleteRelationFragment(firstNode, currentItem, status)
                    dialogDel.show(fragmentM, "tag")
                    Toast.makeText(holder.itemView.context, "suck #${position + 1}", Toast.LENGTH_SHORT).show()

                }
            } else{

                holder.itemView.setOnClickListener{
                    var dialogAdd = AddRelationFragment(firstNode, currentItem, status)
                    dialogAdd.show(fragmentM, "tag")

                    Toast.makeText(holder.itemView.context, "testtttt #${status.toString()}", Toast.LENGTH_SHORT).show()
                }
            }

        }



    }
    // set data and filter (delete duplicate, examole 9 --- 9)
    fun setData(node: MutableList<Node>) {
        this.nodeList = node.filter { it.value != firstEl } as MutableList<Node>
        notifyDataSetChanged()
    }
}