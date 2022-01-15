USE [nacos]
GO

/****** Object:  Table [nacos].[config_info_aggr]    Script Date: 2022/1/15 星期六 22:44:42 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[config_info_aggr](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[data_id] [nvarchar](255) NOT NULL,
	[group_id] [nvarchar](255) NOT NULL,
	[datum_id] [nvarchar](255) NOT NULL,
	[content] [nvarchar](max) NOT NULL,
	[gmt_modified] [datetime2](0) NOT NULL,
	[app_name] [nvarchar](128) NULL,
	[tenant_id] [nvarchar](128) NULL,
 CONSTRAINT [PK_config_info_aggr_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [config_info_aggr$uk_configinfoaggr_datagrouptenantdatum] UNIQUE NONCLUSTERED 
(
	[data_id] ASC,
	[group_id] ASC,
	[tenant_id] ASC,
	[datum_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [nacos].[config_info_aggr] ADD  DEFAULT (NULL) FOR [app_name]
GO

ALTER TABLE [nacos].[config_info_aggr] ADD  DEFAULT (N'') FOR [tenant_id]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.config_info_aggr' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'config_info_aggr'
GO

