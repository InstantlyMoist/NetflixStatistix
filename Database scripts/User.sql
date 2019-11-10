/*
   Sunday, 10 November 201912:52:25
   User: 
   Server: LAPTOP-50HPK24N
   Database: Netflix Statistics
   Application: 
*/

/* To prevent any potential data loss issues, you should review this script in detail before running it outside the context of the database designer.*/
BEGIN TRANSACTION
SET QUOTED_IDENTIFIER ON
SET ARITHABORT ON
SET NUMERIC_ROUNDABORT OFF
SET CONCAT_NULL_YIELDS_NULL ON
SET ANSI_NULLS ON
SET ANSI_PADDING ON
SET ANSI_WARNINGS ON
COMMIT
BEGIN TRANSACTION
GO
CREATE TABLE dbo.[User]
	(
	UserID int NOT NULL,
	FirstName nvarchar(32) NULL,
	LastName nvarchar(32) NULL,
	Password nvarchar(32) NULL,
	Email nvarchar(50) NULL,
	Address nvarchar(50) NULL,
	BirthDate datetime NULL,
	WatchingProfiles nvarchar(50) NULL
	)  ON [PRIMARY]
GO
ALTER TABLE dbo.[User] ADD CONSTRAINT
	PK_User PRIMARY KEY CLUSTERED 
	(
	UserID
	) WITH( STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]

GO
ALTER TABLE dbo.[User] SET (LOCK_ESCALATION = TABLE)
GO
COMMIT
