package com.roozen.alcss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 课程详情表
 * </p>
 *
 * @author <a href="https://roozen.top">Roozen</a>
 * @since 2023-05-24
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("course_detail")
@Schema(name = "CourseDetail对象", description = "课程详情表")
public class CourseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "课程名")
    @TableField("course_name")
    private String courseName;

    @Schema(description = "班级名")
    @TableField("class_name")
    private String className;

    @Schema(description = "任课教师id")
    @TableField("teacher_id")
    private Integer teacherId;

    @Schema(description = "任课教师名")
    @TableField("teacher_name")
    private String teacherName;

    @Schema(description = "创建时间")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @Schema(description = "修改时间")
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
