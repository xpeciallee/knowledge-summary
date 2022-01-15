USE [nacos]
GO

/****** Object:  Table [nacos].[group_capacity]    Script Date: 2022/1/15 星期六 22:46:25 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[group_capacity](
	[id] [numeric](20, 0) IDENTITY(1,1) NOT NULL,
	[group_id] [nvarchar](128) NOT NULL,
	[quota] [bigint] NOT NULL,
	[usage] [bigint] NOT NULL,
	[max_size] [bigint] NOT NULL,
	[max_aggr_count] [bigint] NOT NULL,
	[max_aggr_size] [bigint] NOT NULL,
	[max_history_count] [bigint] NOT NULL,
	[gmt_create] [datetime2](0) NOT NULL,
	[gmt_modified] [datetime2](0) NOT NULL,
 CONSTRAINT [PK_group_capacity_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [group_capacity$uk_group_id] UNIQUE NONCLUSTERED 
(
	[group_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT (N'') FOR [group_id]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT ((0)) FOR [quota]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT ((0)) FOR [usage]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT ((0)) FOR [max_size]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT ((0)) FOR [max_aggr_count]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT ((0)) FOR [max_aggr_size]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT ((0)) FOR [max_history_count]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT (getdate()) FOR [gmt_create]
GO

ALTER TABLE [nacos].[group_capacity] ADD  DEFAULT (getdate()) FOR [gmt_modified]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.group_capacity' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'group_capacity'
GO

