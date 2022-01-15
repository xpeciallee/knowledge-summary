USE [nacos]
GO

/****** Object:  Table [nacos].[config_info]    Script Date: 2022/1/15 星期六 22:44:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[config_info](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[data_id] [nvarchar](255) NOT NULL,
	[group_id] [nvarchar](255) NULL,
	[content] [nvarchar](max) NOT NULL,
	[md5] [nvarchar](32) NULL,
	[gmt_create] [datetime2](0) NOT NULL,
	[gmt_modified] [datetime2](0) NOT NULL,
	[src_user] [nvarchar](max) NULL,
	[src_ip] [nvarchar](50) NULL,
	[app_name] [nvarchar](128) NULL,
	[tenant_id] [nvarchar](128) NULL,
	[c_desc] [nvarchar](256) NULL,
	[c_use] [nvarchar](64) NULL,
	[effect] [nvarchar](64) NULL,
	[type] [nvarchar](64) NULL,
	[c_schema] [nvarchar](max) NULL,
 CONSTRAINT [PK_config_info_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [config_info$uk_configinfo_datagrouptenant] UNIQUE NONCLUSTERED 
(
	[data_id] ASC,
	[group_id] ASC,
	[tenant_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [group_id]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [md5]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (getdate()) FOR [gmt_create]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (getdate()) FOR [gmt_modified]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [src_ip]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [app_name]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (N'') FOR [tenant_id]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [c_desc]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [c_use]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [effect]
GO

ALTER TABLE [nacos].[config_info] ADD  DEFAULT (NULL) FOR [type]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.config_info' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'config_info'
GO

