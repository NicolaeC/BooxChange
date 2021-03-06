package nl.booxchange.widget

import android.content.Context
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.view.View
import android.support.v4.view.ViewCompat


/**
 * Created by Cristian Velinciuc on 3/11/18.
 */
class ActionButtonScrollBehaviour(context: Context?, attributeSet: AttributeSet?): FloatingActionButton.Behavior(context, attributeSet) {
  override fun onStartNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, directTargetChild: View, target: View, axes: Int, type: Int): Boolean {
    return axes == ViewCompat.SCROLL_AXIS_VERTICAL || super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type)
  }

  override fun onNestedScroll(coordinatorLayout: CoordinatorLayout, child: FloatingActionButton, target: View, dxConsumed: Int, dyConsumed: Int, dxUnconsumed: Int, dyUnconsumed: Int, type: Int) {
    super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type)
    if (dyConsumed > 0 && child.visibility == View.VISIBLE) {
      child.hide()
    } else if (dyConsumed < 0 && child.visibility != View.VISIBLE) {
      child.show()
    }
  }
}
