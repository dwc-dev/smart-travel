import request from '@/utils/request'

// 查询景区广告，存储景区广告列表
export function listAdvertisement(query) {
  return request({
    url: '/system/advertisement/list',
    method: 'get',
    params: query
  })
}

// 查询景区广告，存储景区广告详细
export function getAdvertisement(adId) {
  return request({
    url: '/system/advertisement/' + adId,
    method: 'get'
  })
}

// 新增景区广告，存储景区广告
export function addAdvertisement(data) {
  return request({
    url: '/system/advertisement',
    method: 'post',
    data: data
  })
}

// 修改景区广告，存储景区广告
export function updateAdvertisement(data) {
  return request({
    url: '/system/advertisement',
    method: 'put',
    data: data
  })
}

// 删除景区广告，存储景区广告
export function delAdvertisement(adId) {
  return request({
    url: '/system/advertisement/' + adId,
    method: 'delete'
  })
}
