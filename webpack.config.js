var path = require('path');

module.exports = {
    entity: './src/main/app/src/App.tsx',
    devtool: 'sourcemaps',
    cache: true,
    mode: 'development',
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    module: {
        rules: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        preset: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    }
}