const express = require('express');
const mysql = require('mysql2/promise');

const app = express();
const port = 3000;

// MySQL connection configuration
const dbConfig = {
  host: 'mysql', // This will be the service name in docker-compose
  user: 'root',
  password: 'password',
  database: 'mydb'
};

// Create a connection pool
const pool = mysql.createPool(dbConfig);

app.get('/', async (req, res) => {
  try {
    // Test database connection
    const connection = await pool.getConnection();
    const [rows] = await connection.query('SELECT 1 + 1 AS result');
    connection.release();
    
    res.json({
      message: 'Successfully connected to MySQL!',
      testResult: rows[0].result
    });
  } catch (error) {
    res.status(500).json({
      error: 'Database connection failed',
      details: error.message
    });
  }
});

app.listen(port, () => {
  console.log(`Node.js app running on port ${port}`);
}); 