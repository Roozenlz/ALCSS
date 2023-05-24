package com.roozen.alcss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 排课信息表
 * </p>
 *
 * @author <a href="http://roozen.top">Roozen</a>
 * @since 2023-05-20
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("course_scheduling")
@Schema(name = "CourseScheduling对象", description = "排课信息表")
public class CourseScheduling implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "创建时间")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @Schema(description = "修改时间")
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;

    @Schema(description = "所排课程id")
    @TableField("course_id")
    private Integer courseId;

    @Schema(description = "周序")
    @TableField("day_of_week")
    private String dayOfWeek;

    @Schema(description = "课程开始时间，24小时制")
    @TableField("begin_time")
    private LocalTime beginTime;

    @Schema(description = "课程结束时间，24小时制")
    @TableField("end_time")
    private LocalTime endTime;
}
