package com.roozen.alcss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统信息表
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
@TableName("system_info")
@Schema(name = "SystemInfo对象", description = "系统信息表")
public class SystemInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "当前学年，用两个年份表示，中间用-隔开")
    @TableField("current_academic_year")
    private String currentAcademicYear;

    @Schema(description = "当前学年的第几个学期，1表示第一学期，2表示第二学期")
    @TableField("current_term")
    private Byte currentTerm;

    @Schema(description = "总周数")
    @TableField("total_week")
    private Byte totalWeek;

    @Schema(description = "当前周")
    @TableField("current_week")
    private Byte currentWeek;

    @Schema(description = "当前学期的起始日期")
    @TableField("term_start_date")
    private LocalDate termStartDate;

    @Schema(description = "当前学期的终止日期")
    @TableField("term_end_date")
    private LocalDate termEndDate;

    @Schema(description = "创建时间")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @Schema(description = "修改时间")
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
