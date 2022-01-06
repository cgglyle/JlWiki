create table login_log
(
    id              int auto_increment comment '主键'
        primary key,
    login_user_name varchar(127) not null comment '登陆用户名',
    login_time      datetime     null comment '登陆时间',
    login_ip        varchar(63)  null comment '登陆地址',
    is_status       bit          null comment '登陆状态',
    logout_time     datetime     null comment '登出时间'
)
    comment '登陆日志';

create table operation_log
(
    id                int auto_increment comment '主键'
        primary key,
    user_name         varchar(127) not null comment '用户姓名',
    operation_module  varchar(255) null comment '操作模块',
    request_address   varchar(255) null comment '请求地址',
    request_method    varchar(31)  null comment '请求方式(GET,POST,PUT,DELETE)',
    request_parameter longtext     null comment '请求参数',
    return_result     longtext     null comment '返回结果',
    is_status         bit          not null comment '状态（1-成功，0-失败）',
    create_time       datetime     not null comment '创建时间',
    query_end_time    bigint       null comment '执行时间'
)
    comment '操作日志表';

create table role
(
    id               int auto_increment comment '用户角色id'
        primary key,
    role_name        varchar(255)                       null comment '用户角色名称',
    role_description varchar(255)                       null comment '用户角色描述',
    role_user_count  int                                null comment '用户角色使用人数',
    create_time      datetime default CURRENT_TIMESTAMP null comment '用户角色创建时间',
    update_time      datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '用户角色更新时间',
    create_user      int                                null comment '创建用户',
    update_user      int                                null comment '修改者',
    is_status        bit      default b'1'              null comment '用户角色状态',
    is_deleted       bit      default b'1'              null comment '用户角色删除状态',
    is_system        bit      default b'0'              not null comment '是否为系统角色（0-不是，1-是）'
);

create table user
(
    id                        int auto_increment comment '用户id'
        primary key,
    user_name                 varchar(255)                       not null comment '账号名称',
    user_password             varchar(255)                       not null comment '账号密码',
    user_password_update_time datetime                           null comment '密码更新时间',
    user_real_name            varchar(64)                        null comment '用户真实姓名',
    user_gender               int                                null comment '用户性别（0-男，1-女，2-保密）',
    user_age                  int                                null comment '年龄',
    user_nick_name            varchar(255)                       null comment '用户昵称',
    user_icon                 varchar(255)                       null comment '用户头像',
    user_email                varchar(255)                       null comment '用户邮箱',
    user_phone                varchar(255)                       null comment '用户电话',
    user_qq                   varchar(32)                        null comment '用户qq',
    user_wechat               varchar(256)                       null comment '用户微信',
    user_google               varchar(256)                       null comment '用户谷歌',
    user_telegram             varchar(256)                       null comment '用户tg',
    user_twitter              varchar(256)                       null comment '用户推特',
    user_facebook             varchar(256)                       null comment '用户脸书',
    create_time               datetime default CURRENT_TIMESTAMP null comment '用户创建时间',
    update_time               datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '用户更新时间',
    user_login_ip             varchar(128)                       null comment '用户最后登陆ip',
    user_login_num            int                                null comment '用户总登陆次数',
    user_login_time           datetime                           null comment '用户最后登陆时间',
    create_user               int                                null comment '用户创建者',
    is_status                 bit      default b'1'              null comment '用户状态0禁用-1启用',
    is_deleted                bit      default b'1'              null comment '用户删除状态0删除1未删除',
    is_system                 bit      default b'0'              null comment '是否为系统内置用户（0-不是系统用户，1-是系统用户）'
);

create table user_group_relation
(
    id          int auto_increment comment '用户组用户id'
        primary key,
    user_id     int                                not null comment '用户id',
    group_id    int                                not null comment '用户组id',
    create_time datetime default CURRENT_TIMESTAMP null comment '用户组用户创建时间',
    update_time datetime default CURRENT_TIMESTAMP null comment '用户组用户更新时间',
    create_user int                                null comment '创建用户',
    is_deleted  bit      default b'1'              null comment '用户组用户删除状态',
    is_system   bit      default b'0'              null comment '是否为系统内置(0-不是，1-是)',
    is_status   bit      default b'1'              null comment '状态'
);

create table user_groups
(
    id                int auto_increment comment '用户组id'
        primary key,
    group_name        varchar(255)                       null comment '用户组名称',
    group_description varchar(255)                       null comment '用户组描述',
    create_time       datetime default CURRENT_TIMESTAMP null comment '用户组创建时间',
    update_time       datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '用户组更新时间',
    create_user       int                                null,
    update_user       int                                null comment '修改者',
    is_status         bit      default b'1'              null comment '用户组状态',
    is_deleted        bit      default b'1'              null comment '用户组删除状态',
    is_system         bit      default b'0'              null comment '是否为系统组（0-不是，1-是）'
);

create table user_role_relation
(
    id          int auto_increment comment '用户权限id'
        primary key,
    user_id     int                                not null comment '用户id',
    role_id     int                                not null comment '权限id',
    create_time datetime default CURRENT_TIMESTAMP null comment '用户权限创建时间',
    update_time datetime default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '用户权限更新时间',
    create_user int                                null comment '创建用户',
    update_user int                                null comment '修改人',
    is_status   bit      default b'1'              null comment '用户权限状态',
    is_deleted  bit      default b'1'              null comment '用户权限删除状态',
    is_system   bit      default b'0'              null comment '是否为系统创建(0-不是.1-是)'
);


