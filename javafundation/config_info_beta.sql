USE [nacos]
GO

/****** Object:  Table [nacos].[config_info_beta]    Script Date: 2022/1/15 星期六 22:45:17 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[config_info_beta](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[data_id] [nvarchar](255) NOT NULL,
	[group_id] [nvarchar](128) NOT NULL,
	[app_name] [nvarchar](128) NULL,
	[content] [nvarchar](max) NOT NULL,
	[beta_ips] [nvarchar](1024) NULL,
	[md5] [nvarchar](32) NULL,
	[gmt_create] [datetime2](0) NOT NULL,
	[gmt_modified] [datetime2](0) NOT NULL,
	[src_user] [nvarchar](max) NULL,
	[src_ip] [nvarchar](50) NULL,
	[tenant_id] [nvarchar](128) NULL,
 CONSTRAINT [PK_config_info_beta_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [config_info_beta$uk_configinfobeta_datagrouptenant] UNIQUE NONCLUSTERED 
(
	[data_id] ASC,
	[group_id] ASC,
	[tenant_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (NULL) FOR [app_name]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (NULL) FOR [beta_ips]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (NULL) FOR [md5]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (getdate()) FOR [gmt_create]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (getdate()) FOR [gmt_modified]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (NULL) FOR [src_ip]
GO

ALTER TABLE [nacos].[config_info_beta] ADD  DEFAULT (N'') FOR [tenant_id]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.config_info_beta' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'config_info_beta'
GO

