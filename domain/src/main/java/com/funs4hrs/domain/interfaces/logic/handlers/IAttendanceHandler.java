package com.funs4hrs.domain.interfaces.logic.handlers;

import com.funs4hrs.domain.interfaces.logic.IHandlerCRUD;
import com.funs4hrs.domain.models.Attendance;

public interface IAttendanceHandler extends IHandlerCRUD<Attendance,Long> {
    Attendance readAllOpenByUserAndProject(Long user, Long project);
}
