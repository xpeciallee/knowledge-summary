USE [nacos]
GO

/****** Object:  Table [nacos].[tenant_info]    Script Date: 2022/1/15 星期六 22:47:37 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[tenant_info](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[kp] [nvarchar](128) NOT NULL,
	[tenant_id] [nvarchar](128) NULL,
	[tenant_name] [nvarchar](128) NULL,
	[tenant_desc] [nvarchar](256) NULL,
	[create_source] [nvarchar](32) NULL,
	[gmt_create] [bigint] NOT NULL,
	[gmt_modified] [bigint] NOT NULL,
 CONSTRAINT [PK_tenant_info_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [tenant_info$uk_tenant_info_kptenantid] UNIQUE NONCLUSTERED 
(
	[kp] ASC,
	[tenant_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [nacos].[tenant_info] ADD  DEFAULT (N'') FOR [tenant_id]
GO

ALTER TABLE [nacos].[tenant_info] ADD  DEFAULT (N'') FOR [tenant_name]
GO

ALTER TABLE [nacos].[tenant_info] ADD  DEFAULT (NULL) FOR [tenant_desc]
GO

ALTER TABLE [nacos].[tenant_info] ADD  DEFAULT (NULL) FOR [create_source]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.tenant_info' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'tenant_info'
GO

