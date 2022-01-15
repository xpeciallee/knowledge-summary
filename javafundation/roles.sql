USE [nacos]
GO

/****** Object:  Table [nacos].[roles]    Script Date: 2022/1/15 星期六 22:47:09 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [nacos].[roles](
	[username] [varchar](50) NOT NULL,
	[role] [varchar](50) NOT NULL,
 CONSTRAINT [roles$idx_user_role] UNIQUE CLUSTERED 
(
	[username] ASC,
	[role] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

EXEC sys.sp_addextendedproperty @name=N'MS_SSMA_SOURCE', @value=N'nacos.roles' , @level0type=N'SCHEMA',@level0name=N'nacos', @level1type=N'TABLE',@level1name=N'roles'
GO

