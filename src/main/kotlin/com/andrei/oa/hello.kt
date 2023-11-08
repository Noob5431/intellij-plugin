package com.andrei.oa

import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import javax.swing.Icon

class HelloDialogAction : AnAction {
    override fun getActionUpdateThread(): ActionUpdateThread {
        return ActionUpdateThread.BGT
    }

    constructor() : super()

    constructor(text: String?, description: String?, icon: Icon?) : super(text, description, icon)

    override fun actionPerformed(e: AnActionEvent) {
        val currentProject: Project? = e.project
        val message = StringBuilder("${e.presentation.text}")

        val title: String = e.presentation.description
        Messages.showMessageDialog(
                currentProject,
                message.toString(),
                title,
                Messages.getInformationIcon()
        )
    }

    override fun update(e: AnActionEvent) {
        val project: Project? = e.project
        e.presentation.isEnabledAndVisible = project != null
    }
}