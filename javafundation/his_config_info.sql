USE [nacos]
GO

/****** Object:  Table [nacos].[his_config_info]    Script Date: 2022/1/15 星期六 22:46:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[his_config_info](
	[id] [numeric](38, 0) NOT NULL,
	[nid] [numeric](20, 0) IDENTITY(1,1) NOT NULL,
	[data_id] [nvarchar](255) NOT NULL,
	[group_id] [nvarchar](128) NOT NULL,
	[app_name] [nvarchar](128) NULL,
	[content] [nvarchar](max) NOT NULL,
	[md5] [nvarchar](32) NULL,
	[gmt_create] [datetime2](0) NOT NULL,
	[gmt_modified] [datetime2](0) NOT NULL,
	[src_user] [nvarchar](max) NULL,
	[src_ip] [nvarchar](50) NULL,
	[op_type] [nchar](10) NULL,
	[tenant_id] [nvarchar](128) NULL,
 CONSTRAINT [PK_his_config_info_nid] PRIMARY KEY CLUSTERED 
(
	[nid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (NULL) FOR [app_name]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (NULL) FOR [md5]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (getdate()) FOR [gmt_create]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (getdate()) FOR [gmt_modified]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (NULL) FOR [src_ip]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (NULL) FOR [op_type]
GO

ALTER TABLE [nacos].[his_config_info] ADD  DEFAULT (N'') FOR [tenant_id]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.his_config_info' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'his_config_info'
GO

