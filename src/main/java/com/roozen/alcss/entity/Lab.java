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
 * 实验室表
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
@TableName("lab")
@Schema(name = "Lab对象", description = "实验室表")
public class Lab implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "实验室名称")
    @TableField("lab_name")
    private String labName;

    @Schema(description = "实验室类型id")
    @TableField("lab_category_id")
    private Integer labCategoryId;

    @Schema(description = "实验室所拥有的设备数")
    @TableField("device_number")
    private Integer deviceNumber;

    @Schema(description = "座位数，实验室可容纳人数")
    @TableField("seating")
    private Integer seating;

    @Schema(description = "实验室负责人")
    @TableField("principal")
    private Integer principal;

    @Schema(description = "实验室的具体地点")
    @TableField("position")
    private String position;

    @Schema(description = "创建时间")
    @TableField(value = "gmt_create", fill = FieldFill.INSERT)
    private LocalDateTime gmtCreate;

    @Schema(description = "修改时间")
    @TableField(value = "gmt_modified", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime gmtModified;
}
