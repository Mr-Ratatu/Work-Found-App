package com.work.found.core.base.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.work.found.core.base.R

interface FragmentRouter {

    fun addFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        needToBackStack: Boolean = false,
        animation: Animation = Animation.noAnimation()
    )
}

open class FragmentRouterImpl : FragmentRouter {

    private val containerViewId = R.id.main_fl_container

    override fun addFragment(
        fragment: Fragment,
        fragmentManager: FragmentManager,
        needToBackStack: Boolean,
        animation: Animation
    ) {
        fragmentManager.beginTransaction().apply {
            setCustomAnimations(animation)
            setReorderingAllowed(true)
            replace(containerViewId, fragment)

            if (needToBackStack) {
                addToBackStack(fragment::class.toString())
            }
        }.commit()
    }

}