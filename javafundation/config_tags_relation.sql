USE [nacos]
GO

/****** Object:  Table [nacos].[config_tags_relation]    Script Date: 2022/1/15 星期六 22:46:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[config_tags_relation](
	[id] [bigint] NOT NULL,
	[tag_name] [nvarchar](128) NOT NULL,
	[tag_type] [nvarchar](64) NULL,
	[data_id] [nvarchar](255) NOT NULL,
	[group_id] [nvarchar](128) NOT NULL,
	[tenant_id] [nvarchar](128) NULL,
	[nid] [bigint] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_config_tags_relation_nid] PRIMARY KEY CLUSTERED 
(
	[nid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [config_tags_relation$uk_configtagrelation_configidtag] UNIQUE NONCLUSTERED 
(
	[id] ASC,
	[tag_name] ASC,
	[tag_type] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [nacos].[config_tags_relation] ADD  DEFAULT (NULL) FOR [tag_type]
GO

ALTER TABLE [nacos].[config_tags_relation] ADD  DEFAULT (N'') FOR [tenant_id]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.config_tags_relation' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'config_tags_relation'
GO

