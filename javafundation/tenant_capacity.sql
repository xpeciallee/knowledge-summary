USE [nacos]
GO

/****** Object:  Table [nacos].[tenant_capacity]    Script Date: 2022/1/15 星期六 22:47:26 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[tenant_capacity](
	[id] [numeric](20, 0) IDENTITY(1,1) NOT NULL,
	[tenant_id] [nvarchar](128) NOT NULL,
	[quota] [bigint] NOT NULL,
	[usage] [bigint] NOT NULL,
	[max_size] [bigint] NOT NULL,
	[max_aggr_count] [bigint] NOT NULL,
	[max_aggr_size] [bigint] NOT NULL,
	[max_history_count] [bigint] NOT NULL,
	[gmt_create] [datetime2](0) NOT NULL,
	[gmt_modified] [datetime2](0) NOT NULL,
 CONSTRAINT [PK_tenant_capacity_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [tenant_capacity$uk_tenant_id] UNIQUE NONCLUSTERED 
(
	[tenant_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT (N'') FOR [tenant_id]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT ((0)) FOR [quota]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT ((0)) FOR [usage]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT ((0)) FOR [max_size]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT ((0)) FOR [max_aggr_count]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT ((0)) FOR [max_aggr_size]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT ((0)) FOR [max_history_count]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT (getdate()) FOR [gmt_create]
GO

ALTER TABLE [nacos].[tenant_capacity] ADD  DEFAULT (getdate()) FOR [gmt_modified]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.tenant_capacity' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'tenant_capacity'
GO

