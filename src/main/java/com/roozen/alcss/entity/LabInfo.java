package com.roozen.alcss.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
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
 * 实验室信息表
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
@TableName("lab_info")
@Schema(name = "LabInfo对象", description = "实验室信息表")
public class LabInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "实验室名称")
    @TableField("lab_name")
    private String labName;

    @Schema(description = "实验室类别id")
    @TableField("lab_category_id")
    private Long labCategoryId;

    @Schema(description = "实验室拥有的设备数")
    @TableField("device_number")
    private Integer deviceNumber;

    @Schema(description = "座位数，实验室可容纳人数")
    @TableField("seating")
    private Integer seating;

    @Schema(description = "实验室负责人id")
    @TableField("principal_id")
    private Long principalId;

    @Schema(description = "实验室负责人真实姓名")
    @TableField("principal_name")
    private String principalName;

    @Schema(description = "实验室的具体地点")
    @TableField("position")
    private String position;

    @Schema(description = "状态，1表示正常，0表示禁用")
    @TableField("`status`")
    private Byte status;

    @Schema(description = "逻辑删除字段，1表示删除，0表示未删除")
    @TableField("is_deleted")
    @TableLogic
    private Byte isDeleted;

    @Schema(description = "创建时间")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @Schema(description = "修改时间")
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
