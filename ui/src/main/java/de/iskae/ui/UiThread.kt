package de.iskae.ui

import de.iskae.domain.executor.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers

class UiThread : PostExecutionThread {
  override val scheduler: Scheduler
    get() = AndroidSchedulers.mainThread()
}