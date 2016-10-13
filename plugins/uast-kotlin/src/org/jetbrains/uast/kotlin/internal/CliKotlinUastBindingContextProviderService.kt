package org.jetbrains.uast.kotlin.internal

import com.intellij.openapi.project.Project
import org.jetbrains.kotlin.analyzer.AnalysisResult
import org.jetbrains.kotlin.codegen.ClassBuilderMode
import org.jetbrains.kotlin.codegen.state.IncompatibleClassTracker
import org.jetbrains.kotlin.codegen.state.KotlinTypeMapper
import org.jetbrains.kotlin.descriptors.ModuleDescriptor
import org.jetbrains.kotlin.fileClasses.NoResolveFileClassesProvider
import org.jetbrains.kotlin.load.java.JvmAbi
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.resolve.BindingContext
import org.jetbrains.kotlin.resolve.BindingTrace
import org.jetbrains.kotlin.resolve.jvm.extensions.AnalysisCompletedHandlerExtension
import org.jetbrains.uast.kotlin.KotlinUastBindingContextProviderService

class CliKotlinUastBindingContextProviderService : KotlinUastBindingContextProviderService {
    val Project.analysisCompletedHandler: UastAnalysisCompletedHandlerExtension?
        get() = getExtensions(AnalysisCompletedHandlerExtension.extensionPointName)
                .filterIsInstance<UastAnalysisCompletedHandlerExtension>()
                .firstOrNull()

    override fun getBindingContext(element: KtElement): BindingContext {
        return element.project.analysisCompletedHandler?.getBindingContext() ?: BindingContext.EMPTY
    }

    override fun getTypeMapper(element: KtElement): KotlinTypeMapper? {
        return element.project.analysisCompletedHandler?.getTypeMapper()
    }
}

class UastAnalysisCompletedHandlerExtension : AnalysisCompletedHandlerExtension {
    private var context: BindingContext? = null
    private var typeMapper: KotlinTypeMapper? = null

    fun getBindingContext() = context

    fun getTypeMapper(): KotlinTypeMapper? {
        if (typeMapper != null) return typeMapper
        val bindingContext = context ?: return null

        val typeMapper = KotlinTypeMapper(bindingContext, ClassBuilderMode.LIGHT_CLASSES, NoResolveFileClassesProvider,
                IncompatibleClassTracker.DoNothing, JvmAbi.DEFAULT_MODULE_NAME)
        this.typeMapper = typeMapper
        return typeMapper
    }

    override fun analysisCompleted(
            project: Project,
            module: ModuleDescriptor,
            bindingTrace: BindingTrace,
            files: Collection<KtFile>
    ): AnalysisResult? {
        context = bindingTrace.bindingContext
        return null
    }
}