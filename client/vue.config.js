module.exports = {
  productionSourceMap: false,
  // IF YOU UNCOMMENT THIS MAKE SURE TO UPDATE server/src/main/resources/templates/index.html AFTER BUILDING
  // pages: {
  //   index: {
  //     entry: 'src/main.js',
  //     template: 'public/index.html',
  //     filename: '../../server/src/main/resources/templates/index.html'
  //   }
  // },
  devServer: {
    proxy: 'http://localhost:8080'
  },
  // KEEP THIS COMMENTED WHILE DEVELOPING. UNCOMMENT ONLY TO BUILD
  // chainWebpack: config => {
  //   if(config.plugins.has('extract-css')) {
  //     const extractCSSPlugin = config.plugin('extract-css')
  //     extractCSSPlugin && extractCSSPlugin.tap(() => [{
  //       filename: '../../server/src/main/resources/static/css/[name].css',
  //       chunkFilename: '../../server/src/main/resources/static/css/[name].css'
  //     }])
  //   }
  // },
  // configureWebpack: {
  //   output: {
  //     filename: '../../server/src/main/resources/static/js/app.js',
  //     chunkFilename: '../../server/src/main/resources/static/js/[name].js'
  //   }
  // }
}